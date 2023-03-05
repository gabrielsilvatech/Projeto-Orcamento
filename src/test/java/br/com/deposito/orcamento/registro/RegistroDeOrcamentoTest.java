package br.com.deposito.orcamento.registro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.deposito.DomainException;
import br.com.deposito.http.HttpClient;
import br.com.deposito.orcamento.Orcamento;
import br.com.deposito.orcamento.RegistroDeOrcamento;

class RegistroDeOrcamentoTest {

	// A classe de registro é um exemplo utilizando o Designer pattern Adapter,
	// se utilizando da interface HttpAdapter e da class HttpClient,
	// por isso sua URL é ficticio e ao realizar o registro lançaria uma RuntimeException. 
	
	@Test
	void TestDeUmRegistroDeOrcamentoEmUmaApiExternaOTesteLancaUmaExceptionAUrlNaoExiste() {
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		orcamento.finalizar();
		
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new HttpClient());
		assertThrows(RuntimeException.class, 
				() -> registro.registrar(orcamento));
	}
	
	@Test
	void TestDeRegistroLancaUmDomainExceptionOrcamentoNaoEstaFinalizado() {
		Orcamento orcamento = new Orcamento();						
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new HttpClient());
		assertThrows(DomainException.class, 
				() -> registro.registrar(orcamento));
	}

}
