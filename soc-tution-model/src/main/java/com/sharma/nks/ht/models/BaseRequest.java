package com.sharma.nks.ht.models;

import java.util.Map;

public class BaseRequest {
	
	private Map<String,String> extension;

	public Map<String, String> getExtension() {
		return extension;
	}

	public void setExtension(Map<String, String> extension) {
		this.extension = extension;
	}

}
