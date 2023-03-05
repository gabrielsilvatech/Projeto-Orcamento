package br.com.deposito.imposto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.deposito.material.Material;
import br.com.deposito.orcamento.Orcamento;

class CalculadoraDeImpostosTest {

	@Test
	void TestCalcularOImpostoDeDezPorCentoParaPagamentoComCartaoCred() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		BigDecimal imposto = calculadora.calcularImposto(orcamento, new CartaoCred(null));
		assertEquals(new BigDecimal("10.00"), imposto);
	}
	
	@Test
	void TestCalcularOImpostoDeCincoPorCentoParaLocalidadeEntrega() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		BigDecimal imposto = calculadora.calcularImposto(orcamento, new LocalidadeEntrega(null));
		assertEquals(new BigDecimal("5.00"), imposto);
	}
	
	@Test
	void TestCalcularMaisDeUmIposto() {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItens(new Material(new BigDecimal("100.00")));
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		BigDecimal imposto = calculadora.calcularImposto(orcamento, new CartaoCred(new LocalidadeEntrega(null)));
		assertEquals(new BigDecimal("15.00"), imposto);
	}

}
