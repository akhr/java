package com.akh.JSONParserTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Tester {

	public Tester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuffer finalString = new StringBuffer();
		
		try{
			FileInputStream fstream = new FileInputStream("C:\\AkhashSpace\\eclipse-java-juno-SR1-win32-x86_64\\workspace\\Java_POC\\src\\com\\akh\\JSONParserTest\\jsonInput.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			while ((strLine = br.readLine()) != null)   {
				finalString.append(strLine);
			}
			in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
		System.out.println("JSON Read from FILE = "+ finalString.toString());
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(finalString.toString());
			List<App> apps = JSONParser.parse(jsonObject);
			System.out.println("# of Apps read from JSON = "+ apps.size());
			for(App app : apps){
				System.out.println("App ID : " +app.getAppId());
				System.out.println("App Name : " +app.getAppName());
				System.out.println("App Version Code : " +app.getVersionCode());
				System.out.println("App Required : " +app.isRequired());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
