package com.ak.sample;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

public class Tester {
	
	private static final String TAG_KNOX_VPN_ATTRIBUTE = "KNOX_VPN_PARAMETERS";
	private static final String TAG_PROFILE_ATTRIBUTE = "profile_attribute";
	private static final String TAG_PROFILE = "profile";
	private static final String TAG_HOST = "host";
	private static final String TAG_SSL = "ssl";
	private static final String TAG_BASIC = "basic";
	private static final String TAG_USERNAME = "username";
	private static final String TAG_PASSWORD = "password";
	private static final String TAG_VENDOR = "vendor";
	private static final String TAG_LOGON_MODE = "logonMode";

	public static void main(String[] args) {
		StringBuffer finalString = new StringBuffer();
		JSONObject jsonObject = null;
		try {	
			InputStream iStream = Tester.class.getResourceAsStream("knox.txt");
			DataInputStream in = new DataInputStream(iStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				finalString.append(strLine);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			jsonObject = new JSONObject(finalString.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		parseJSON(jsonObject);

	}

	public static void parseJSON(JSONObject inputJsonObj) {

		if( inputJsonObj != null){
			try {
				JSONObject knoxVPNParameters;

				knoxVPNParameters = inputJsonObj.getJSONObject(TAG_KNOX_VPN_ATTRIBUTE);
				JSONObject profileAttributes = knoxVPNParameters.getJSONObject(TAG_PROFILE_ATTRIBUTE);
				String profileName = profileAttributes.getString(TAG_PROFILE);
				System.out.println("TAG_PROFILE = "+profileName);

				String host = profileAttributes.getString(TAG_HOST);
				System.out.println("TAG_HOST = "+host);

				JSONObject basic_ssl = knoxVPNParameters.getJSONObject(TAG_SSL).getJSONObject(TAG_BASIC);
				String userName = basic_ssl.getString(TAG_USERNAME);
				System.out.println("TAG_USERNAME = "+userName);

				String pwd = basic_ssl.getString(TAG_PASSWORD);
				System.out.println("TAG_PASSWORD = "+pwd);

				JSONObject vendor = knoxVPNParameters.getJSONObject(TAG_VENDOR);
				String logonMode = vendor.getString(TAG_LOGON_MODE);
				System.out.println("TAG_LOGON_MODE = "+logonMode);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("");

		}
	}

}
