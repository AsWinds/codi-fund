package com.codi.bus.core.resultModel;

public class AppUpdateResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	public AppUpdateResult(boolean success, String errorMsg) {
		super(success, errorMsg);
	}
	
	private boolean needForceUpdate;
	private String newVersion;
	private String downloadPath;
	private String releaseNotes;
	
	public boolean getNeedForceUpdate() {
		return needForceUpdate;
	}
	public void setNeedForceUpdate(boolean needForceUpdate) {
		this.needForceUpdate = needForceUpdate;
	}
	public String getNewVersion() {
		return newVersion;
	}
	public void setNewVersion(String newVersion) {
		this.newVersion = newVersion;
	}
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public String getReleaseNotes() {
		return releaseNotes;
	}
	public void setReleaseNotes(String releaseNotes) {
		this.releaseNotes = releaseNotes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
