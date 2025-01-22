package br.com.rhribeiro25.interfaces.http;

import java.util.Map;

public class ApacheHttpAdapter implements HttpAdapter {

	/**
	 * Posts data to a specified URL using Apache HTTP Client.
	 *
	 * Design Pattern: Adapter
	 * - The ApacheHttpAdapter class implements the HttpAdapter interface, adapting the use of Apache HTTP Client to the internal application logic.
	 * - The Adapter pattern allows clients to interact with Apache HTTP Client without directly coupling the client code to it.
	 */
	@Override
	public void post(String url, Map<String, Object> data) {
		// Call to API using Apache HTTP Client...
		System.out.println("Registering budget via Apache HTTP Client");
	}
}
