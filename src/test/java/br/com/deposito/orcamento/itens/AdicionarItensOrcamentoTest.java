package br.com.deposito.orcamento.itens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.deposito.material.Material;
import br.com.deposito.orcamento.Orcamento;

class AdicionarItensOrcamentoTest {

	private BigDecimal valor;
	private int quantidadeItens;

	@Test
	void TestAdiconandoItensAoOrcamentoQuantidadeItensEValor() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		valor = orcamento.getValor();
		quantidadeItens = orcamento.getQuantidadeItens();
		assertEquals(new BigDecimal("300.00"), valor);
		assertEquals(3, quantidadeItens);
	}
	
	@Test
	void TestAdiconandoUmOrcamentoEmOutroOrcamentoQuantidadeItensEValor() {
		Orcamento primeiro = new Orcamento();
		primeiro.adicionarItens(new Material(new BigDecimal("100.00")));
		primeiro.adicionarItens(new Material(new BigDecimal("100.00")));
		primeiro.adicionarItens(new Material(new BigDecimal("100.00")));

		Orcamento segundo = new Orcamento();
		segundo.adicionarItens(new Material(new BigDecimal("100.00")));
		segundo.adicionarItens(new Material(new BigDecimal("100.00")));
		segundo.adicionarItens(new Material(new BigDecimal("100.00")));
		segundo.adicionarItens(primeiro);

		valor = segundo.getValor();
		quantidadeItens = segundo.getQuantidadeItens();
		assertEquals(new BigDecimal("600.00"), valor);
		assertEquals(4, quantidadeItens);
	}
	
	@Test
	void TestOrcamentoQuantidadeItensEValorZerados() {
		Orcamento orcamento = new Orcamento();
		valor = orcamento.getValor();
		quantidadeItens = orcamento.getQuantidadeItens();
		assertEquals(new BigDecimal("0.00"), valor);
		assertEquals(0, quantidadeItens);
	}
}
