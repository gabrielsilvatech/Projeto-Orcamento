package br.com.deposito.imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.orcamento.Orcamento;

public class CartaoCred extends Imposto {
		
	public CartaoCred(Imposto outro) {
		super(outro);
	}

	public BigDecimal calcularImposto(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_UP);
	}
}
