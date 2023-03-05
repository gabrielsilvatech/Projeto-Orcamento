package br.com.deposito.imposto;

import java.math.BigDecimal;

import br.com.deposito.orcamento.Orcamento;

public class CalculadoraDeImpostos {
	public BigDecimal calcularImposto (Orcamento orcamento, Imposto imposto) {
		return imposto.efetuarCalculo(orcamento);
	}
}
