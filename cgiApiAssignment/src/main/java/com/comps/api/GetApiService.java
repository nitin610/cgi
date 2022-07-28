package com.comps.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class GetApiService  {
  

	public  HashMap<String, String>  getCompletedStatusOfID(int id) throws ClientProtocolException, IOException, JSONException
	{
		int statusCode = 0;

		HashMap<String, String> map = new HashMap<String, String>();

		String completedStatus = "";
		HttpClient client = new DefaultHttpClient();
		String url = "https://jsonplaceholder.typicode.com/todos/";

		HttpGet request = new HttpGet(url);
		request.addHeader("accept", "application/json");

		System.out.println("Calling Service.......");

		HttpResponse response = client.execute(request);
		statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Response Code from the API :" +statusCode);
		map.put("StatusCode", Integer.toString(statusCode));

		String json = IOUtils.toString(response.getEntity().getContent());

		JSONArray array = new JSONArray(json);
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);

			if (object.getInt("id") == id) {

				completedStatus = object.getString("completed");
				break;

			}

		}

		map.put("completedStatus", completedStatus);
		System.out.println("Completion Status of  ID :" +id+" is "+completedStatus);
		System.out.println();
		return map;

		
	}
	

}

