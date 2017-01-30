package com.akh.JSON;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser {

	private static final String TAG_RESULTS = "results";
	private static final String TAG_ID = "appId";
	private static final String TAG_TYPE = "type";
	private static final String TAG_MANAGED = "managed";
	private static final String TAG_NAME = "appName";
	private static final String TAG_ICON_URL = "icon";
	private static final String TAG_SCREENSHOT_URLs = "screenshotUrls";
	private static final String TAG_DOWNLOAD_URL = "downloadUrl";
	private static final String TAG_CATEGORY = "category";
	private static final String TAG_DESCRIPTION = "description";
	private static final String TAG_VERSION = "version";
	private static final String TAG_VERSION_CODE = "versionCode";
	private static final String TAG_RELEASE_DATE = "releaseDate";
	private static final String TAG_PUBLISHER_NAME = "publisherName";
	private static final String TAG_RELEASE_NOTES = "releaseNotes";
	private static final String TAG_FILE_SIZE_BYTES = "fileSizeBytes";
	private static final String TAG_AVG_USER_RATING = "averageUserRating";
	private static final String TAG_USER_RATING_COUNT = "userRatingCount";
	private static final String TAG_LAST_USER_RATING = "lastUserRating";
	private static final String TAG_REQUIRED = "required";
	private static final String TAG_URL_SCHEME = "urlscheme";



	JSONArray apps = null;

	public JSONParser() {

	}

	public static List<App> parse(JSONObject jsonObject) throws JSONException, MalformedURLException {

		JSONArray appsArray;
		List<App> apps; 
		
		try {
			appsArray = jsonObject.getJSONArray(TAG_RESULTS);

			apps = new ArrayList<App>(appsArray.length());

			for(int i=0; i<appsArray.length(); i++){
				JSONObject appJSONObject = (JSONObject) appsArray.get(i);
				App app = new App();

				app.setAppId(appJSONObject.getString(TAG_ID));
				AppType type = AppType.getEnum(appJSONObject.getString(TAG_TYPE));
				if(type != null){
					app.setAppType(type);
				}else{
					app.setAppType(AppType.ENTERPRISE);
				}
				app.setIsManaged(appJSONObject.getBoolean(TAG_MANAGED));
				app.setAppName(appJSONObject.getString(TAG_NAME));
				try {
					app.setIconURL(new URL(appJSONObject.getString(TAG_ICON_URL)));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}

				try{
					JSONArray screenshotURLs = appJSONObject.getJSONArray(TAG_SCREENSHOT_URLs);
					List<URL> urls = new ArrayList<URL>();
					for(int j=0; j<screenshotURLs.length();j++){
						try {
							urls.add(new URL(screenshotURLs.getString(j)));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
					}
					app.setScreenShotURLs(urls);
				}catch(JSONException e){
					//Screenshot URL can be null 
					e.printStackTrace();
				}

				try {
					app.setDownloadURL(new URL(appJSONObject.getString(TAG_DOWNLOAD_URL)));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
					throw e1; // .apk download URL should be valid
				}
				
				try{
					JSONArray categories = appJSONObject.getJSONArray(TAG_CATEGORY);
					List<String> categoriesList = new ArrayList<String>();
					for(int k=0; k<categories.length();k++){
						categoriesList.add(categories.getString(k));
					}
					app.setCategory(categoriesList);
				}catch(JSONException e){
					//Category can be null 
					e.printStackTrace();
				}
				
				app.setDescription(appJSONObject.getString(TAG_DESCRIPTION));
				app.setVersion(appJSONObject.getString(TAG_VERSION));
				app.setVersionCode(appJSONObject.getLong(TAG_VERSION_CODE));

				try {
					app.setReleaseDate(ISO8601DateFormatter.toDate(appJSONObject.getString(TAG_RELEASE_DATE)));
				} catch (ParseException e) {
					app.setReleaseDate(null);
					e.printStackTrace();
				}

				app.setPublisher(appJSONObject.getString(TAG_PUBLISHER_NAME));
				app.setReleaseNotes(appJSONObject.getString(TAG_RELEASE_NOTES));
				app.setFileSizeBytes(Long.parseLong(appJSONObject.getString(TAG_FILE_SIZE_BYTES)));
				app.setAverageUserRating(appJSONObject.getDouble(TAG_AVG_USER_RATING));
				app.setUserRatingCount(appJSONObject.getLong(TAG_USER_RATING_COUNT));
				app.setLastUserRating(appJSONObject.getDouble(TAG_LAST_USER_RATING));
				app.setRequired(appJSONObject.getBoolean(TAG_REQUIRED));
				app.setURLScheme(appJSONObject.getString(TAG_URL_SCHEME));

				apps.add(app);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw e; // JSON Response should be valid
		}
		return apps;
	}

}
