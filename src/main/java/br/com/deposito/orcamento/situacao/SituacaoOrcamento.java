package br.com.deposito.orcamento.situacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.DomainException;
import br.com.deposito.orcamento.Orcamento;

public abstract class SituacaoOrcamento {
	
	public BigDecimal calcularValorDesconto (Orcamento orcamento) {
		return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Orcamento não encontra se em situação de ser Aprovado");
	}

	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Orcamento não encontra se em situação de ser Reprovado");
	}

	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Orcamento não encontra se em situação de ser Finalizado");
	}
}
