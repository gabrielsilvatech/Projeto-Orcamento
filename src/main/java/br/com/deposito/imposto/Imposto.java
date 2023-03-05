package br.com.deposito.imposto;

import java.math.BigDecimal;

import br.com.deposito.orcamento.Orcamento;

public abstract class Imposto {
	
	protected Imposto outro;
	
	public Imposto(Imposto outro) {
		this.outro = outro;
	}

	protected abstract BigDecimal calcularImposto (Orcamento orcamento);
	
	public BigDecimal efetuarCalculo (Orcamento orcamento) {
		BigDecimal valorImposto = calcularImposto(orcamento);
		BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
		
		if (outro != null) {
			valorDoOutroImposto = outro.calcularImposto(orcamento);
		}
		return valorImposto.add(valorDoOutroImposto);
		
	}
}
