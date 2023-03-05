package br.com.deposito.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpClient implements HttpAdapter {

	@Override
	public void post(String url, Map<String, Object> dados) {

		try {
			URL urlDaApi = new URL(url);
			URLConnection connection = urlDaApi.openConnection();
			connection.connect();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao enviar a requisicao HTTP", e);
		}
		
	}

}
