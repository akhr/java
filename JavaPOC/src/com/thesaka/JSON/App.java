package com.thesaka.JSON;

import java.net.URL;
import java.util.Date;
import java.util.List;

public class App {
	
	private String mAppId;
	private AppType mAppType;
	private boolean mIsManaged;
	private String mAppName;
	private URL mIconURL;
	private List<URL> mScreenShotURLs;
	private URL mDownloadURL;
	private List<String> mCategory;
	private String mDescription;
	private String mVersion;
	private long mVersionCode;
	private Date mReleaseDate;
	private String mPublisher;
	private String mReleaseNotes;
	private long mFileSizeBytes;
	private double mAverageUserRating;
	private long mUserRatingCount;
	private double mLastUserRating;
	private boolean mRequired;
	private String mURLScheme;
	
	public App() {
	}
	
	public String getAppId() {
		return mAppId;
	}
	public void setAppId(String mAppId) {
		this.mAppId = mAppId;
	}
	public AppType getAppType() {
		return mAppType;
	}
	public void setAppType(AppType mAppType) {
		this.mAppType = mAppType;
	}
	public boolean isManaged() {
		return mIsManaged;
	}
	public void setIsManaged(boolean mIsManaged) {
		this.mIsManaged = mIsManaged;
	}
	public String getAppName() {
		return mAppName;
	}
	public void setAppName(String mAppName) {
		this.mAppName = mAppName;
	}
	public URL getIconURL() {
		return mIconURL;
	}
	public void setIconURL(URL mIconURL) {
		this.mIconURL = mIconURL;
	}
	public List<URL> getScreenShotURLs() {
		return mScreenShotURLs;
	}
	public void setScreenShotURLs(List<URL> mScreenShotURLs) {
		this.mScreenShotURLs = mScreenShotURLs;
	}
	public URL getDownloadURL() {
		return mDownloadURL;
	}
	public void setDownloadURL(URL mDownloadURL) {
		this.mDownloadURL = mDownloadURL;
	}
	public List<String> getCategory() {
		return mCategory;
	}
	public void setCategory(List<String> mCategory) {
		this.mCategory = mCategory;
	}
	public String getDescription() {
		return mDescription;
	}
	public void setDescription(String mDescription) {
		this.mDescription = mDescription;
	}
	public String getVersion() {
		return mVersion;
	}
	public void setVersion(String mVersion) {
		this.mVersion = mVersion;
	}
	public long getVersionCode() {
		return mVersionCode;
	}
	public void setVersionCode(long mVersionCode) {
		this.mVersionCode = mVersionCode;
	}
	public Date getReleaseDate() {
		return mReleaseDate;
	}
	public void setReleaseDate(Date mReleaseDate) {
		this.mReleaseDate = mReleaseDate;
	}
	public String getPublisher() {
		return mPublisher;
	}
	public void setPublisher(String mPublisher) {
		this.mPublisher = mPublisher;
	}
	public String getReleaseNotes() {
		return mReleaseNotes;
	}
	public void setReleaseNotes(String mReleaseNotes) {
		this.mReleaseNotes = mReleaseNotes;
	}
	public long getFileSizeBytes() {
		return mFileSizeBytes;
	}
	public void setFileSizeBytes(long mFileSizeBytes) {
		this.mFileSizeBytes = mFileSizeBytes;
	}
	public double getAverageUserRating() {
		return mAverageUserRating;
	}
	public void setAverageUserRating(double mAverageUserRating) {
		this.mAverageUserRating = mAverageUserRating;
	}
	public long getUserRatingCount() {
		return mUserRatingCount;
	}
	public void setUserRatingCount(long mUserRatingCount) {
		this.mUserRatingCount = mUserRatingCount;
	}
	public double getLastUserRating() {
		return mLastUserRating;
	}
	public void setLastUserRating(double mLastUserRating) {
		this.mLastUserRating = mLastUserRating;
	}
	public boolean isRequired() {
		return mRequired;
	}
	public void setRequired(boolean mRequired) {
		this.mRequired = mRequired;
	}
	public String getURLScheme() {
		return mURLScheme;
	}
	public void setURLScheme(String mURLScheme) {
		this.mURLScheme = mURLScheme;
	}
	
	
	
}
