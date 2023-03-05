package br.com.deposito.orcamento.situacao;

import br.com.deposito.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacaoOrcamento(new Finalizado());
	}
}
