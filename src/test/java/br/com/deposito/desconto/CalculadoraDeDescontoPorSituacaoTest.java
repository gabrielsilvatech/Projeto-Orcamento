package br.com.deposito.desconto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.deposito.material.Material;
import br.com.deposito.orcamento.Orcamento;

class CalculadoraDeDescontoPorSituacaoTest {

	@Test
	void TestDescontoParaSituacaoEmAnaliseDeCincoPorCento() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.descontoExtra();
		BigDecimal desconto = orcamento.getValor();	
		assertEquals(new BigDecimal("95.00"),desconto);
	}
	
	@Test
	void TestDescontoParaSituacaoAprovadoDeDoisPorCento() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.aprovar();
		orcamento.descontoExtra();
		BigDecimal desconto = orcamento.getValor();	
		assertEquals(new BigDecimal("98.00"),desconto);
	}
	
	@Test
	void TestDescontoParaSituacaoReprovadoDeZeroPorCento() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.reprovar();
		orcamento.descontoExtra();
		BigDecimal desconto = orcamento.getValor();	
		assertEquals(new BigDecimal("100.00"),desconto);
	}
	
	@Test
	void TestDescontoParaSituacaoFinalizadoDeZeroPorCento() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.aprovar();
		orcamento.finalizar();
		orcamento.descontoExtra();
		BigDecimal desconto = orcamento.getValor();	
		assertEquals(new BigDecimal("100.00"),desconto);
	}

}
