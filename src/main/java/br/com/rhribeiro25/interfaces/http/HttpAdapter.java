package br.com.rhribeiro25.interfaces.http;

import java.util.Map;

public interface HttpAdapter {

	/**
	 * Posts data to a specified URL.
	 *
	 * This is a general interface for HTTP adapters that can be implemented by various types of HTTP client libraries.
	 */
	void post(String url, Map<String, Object> data);
}