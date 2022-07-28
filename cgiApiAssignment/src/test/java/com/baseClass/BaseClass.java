package com.baseClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.pos.api.VerifyGetApiDetails;

public class BaseClass {

	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
 
	        VerifyGetApiDetails a =  new VerifyGetApiDetails();
	        
	        a.verifyGetApiStatuCodeAndCompletedStatus(2);
		
	}

}
