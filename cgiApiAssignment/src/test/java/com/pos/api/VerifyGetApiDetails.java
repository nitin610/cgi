package com.pos.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.comps.api.GetApiService;



public class VerifyGetApiDetails
{
	GetApiService  getapi =  new GetApiService();
	
	public void verifyGetApiStatuCodeAndCompletedStatus(int id) throws ClientProtocolException, IOException, JSONException
	{
		
		HashMap<String, String> map = new HashMap<String, String>();

		map = getapi.getCompletedStatusOfID(id);
	
	  try
	  {
		
		assertEquals(Integer.parseInt(map.get("StatusCode")),200);
		System.out.println("Response code Verification Passed Succesfully");
	  
		assertFalse(Boolean.parseBoolean(map.get("completedStatus")));
		System.out.println("Completed Status Verification Passed Succesfully");
	
	  }
	  
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
		
	}

	
}