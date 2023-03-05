package br.com.deposito.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.orcamento.Orcamento;

public class DescontoPeloValor extends Desconto {

	public DescontoPeloValor(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return (orcamento.getValor().compareTo(new BigDecimal("9999.99")) > 0);

	}
}
