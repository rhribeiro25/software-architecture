package br.com.rhribeiro25.interfaces.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpAdapter implements HttpAdapter {

	/**
	 * Posts data to a specified URL using Java's built-in URLConnection.
	 *
	 * Design Pattern: Adapter
	 * - The JavaHttpAdapter class implements the HttpAdapter interface, adapting the Java URLConnection class to the internal application logic.
	 * - The Adapter pattern allows the client code to remain agnostic of the specific HTTP library (Apache HTTP Client, URLConnection, etc.).
	 */
	@Override
	public void post(String url, Map<String, Object> data) {
		try {
			URL urlApi = new URL(url);
			URLConnection connection = urlApi.openConnection();
			connection.connect();
		} catch (Exception e) {
			throw new RuntimeException("Error sending data!", e);
		}
	}
}
