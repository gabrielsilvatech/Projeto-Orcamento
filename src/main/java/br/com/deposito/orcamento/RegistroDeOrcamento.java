package br.com.deposito.orcamento;

import java.util.Map;

import br.com.deposito.DomainException;
import br.com.deposito.http.HttpAdapter;

public class RegistroDeOrcamento {

	private HttpAdapter http;

	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}
	
	public void registrar(Orcamento orcamento) {
		
		if (!orcamento.isFinalizado()) {
			throw new DomainException("Orcamento não está finalizado");
		}
		
		String url = "http://test.apiexterna/orcamento";
		Map<String, Object> dados = Map.of(
				"valor", orcamento.getValor(),
				"quantidadeItens", orcamento.getQuantidadeItens());
		http.post(url, dados);
	}
	
}
