package br.com.deposito.orcamento.situacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento {
	
	public BigDecimal calcularValorDesconto(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.02")).setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacaoOrcamento(new Finalizado());
	}
}
