package com.ycc.redbabyserver.domain;

public class Version {
	private int id;
	private String isnew;
	private String version;
	private String force;
	private String url;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsnew() {
		return isnew;
	}
	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getForce() {
		return force;
	}
	public void setForce(String force) {
		this.force = force;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Version [id=" + id + ", isnew=" + isnew + ", version=" + version + ", force=" + force + ", url=" + url
				+ ", state=" + state + "]";
	}
	
}
