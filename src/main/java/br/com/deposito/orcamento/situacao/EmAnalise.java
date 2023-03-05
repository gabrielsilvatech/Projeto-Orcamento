package br.com.deposito.orcamento.situacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.orcamento.Orcamento;

public class EmAnalise extends SituacaoOrcamento {
	
	public BigDecimal calcularValorDesconto(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
	}
	
	@Override
	public void aprovar(Orcamento orcamento) {
		orcamento.setSituacaoOrcamento(new Aprovado());
	}
	
	@Override
	public void reprovar(Orcamento orcamento) { 
		orcamento.setSituacaoOrcamento(new Reprovado());
	}
}
