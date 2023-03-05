package br.com.deposito.imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.orcamento.Orcamento;

public class LocalidadeEntrega extends Imposto {

	public LocalidadeEntrega(Imposto outro) {
		super(outro);
	}

	protected BigDecimal calcularImposto(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
	}

}
