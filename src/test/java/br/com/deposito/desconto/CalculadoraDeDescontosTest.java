package br.com.deposito.desconto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.deposito.material.Material;
import br.com.deposito.orcamento.Orcamento;

class CalculadoraDeDescontosTest {

	@Test
	void TestDescontoDeDezPorCentoParaOrcamentoComDezOuMaisItens() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		BigDecimal desconto = calculadora.calcular(orcamento);
		assertEquals(new BigDecimal("100.00"), desconto);
	}

	@Test
	void TestDescontoDeCincoPorCentoParaOrcamentoComValorMaiorOuIgualDezMil() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("10000.00")));
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		BigDecimal desconto = calculadora.calcular(orcamento);
		assertEquals(new BigDecimal("500.00"), desconto);
	}

	@Test
	void TestSemNenhumDesconto() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("1000.00")));
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		BigDecimal desconto = calculadora.calcular(orcamento);
		assertEquals(new BigDecimal("0.00"), desconto);
	}

}
