package omni.commons.core;

import java.util.Map;

public class Response {

	private boolean response;
	private Map<String, String> responseProperties;

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public Map<String, String> getResponseProperties() {
		return responseProperties;
	}

	public void setResponseProperties(Map<String, String> responseProperties) {
		this.responseProperties = responseProperties;
	}
}