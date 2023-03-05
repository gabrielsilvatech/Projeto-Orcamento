package br.com.deposito.desconto;

import java.math.BigDecimal;

import br.com.deposito.orcamento.Orcamento;

public class CalculadoraDeDescontos {
		
	public BigDecimal calcular (Orcamento orcamento) {
		Desconto desconto = new DescontoPorQuantidadeDeItens(
				new DescontoPeloValor(
						new SemDesconto()));
		return desconto.calcular(orcamento);
	}		
}
