package br.com.deposito.orcamento.situacao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.deposito.DomainException;
import br.com.deposito.orcamento.Orcamento;

class SituacaoOrcamentoTest {

	@Test
	void TestaTranssicaoDeUmOrcamentoEmAnaliseParaFinalizadoLancaException() {
		Orcamento orcamento = new Orcamento();
		assertThrows(DomainException.class, 
				() -> orcamento.finalizar());
	}
		
	@Test
	void TestaTranssicaoDeUmOrcamentoFinalizadoParaAprovadoLancaException() {
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		orcamento.finalizar();
		assertThrows(DomainException.class, 
				() -> orcamento.aprovar());
	}
	
	@Test
	void TestaTranssicaoDeUmOrcamentoFinalizadoParaReprovadoLancaException() {
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		orcamento.finalizar();
		assertThrows(DomainException.class, 
				() -> orcamento.reprovar());
	}
	
	@Test
	void TestaTranssicaoDeUmOrcamentoAprovadoParaReprovadoLancaException() {
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		assertThrows(DomainException.class, 
				() -> orcamento.reprovar());
	}
	
	@Test
	void TestaTranssicaoDeUmOrcamentoReprovadoParaAprovadoLancaException() {
		Orcamento orcamento = new Orcamento();
		orcamento.reprovar();
		assertThrows(DomainException.class, 
				() -> orcamento.aprovar());
	}

}
