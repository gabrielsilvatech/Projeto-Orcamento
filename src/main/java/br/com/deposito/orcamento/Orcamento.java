package br.com.deposito.orcamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import br.com.deposito.orcamento.situacao.EmAnalise;
import br.com.deposito.orcamento.situacao.Finalizado;
import br.com.deposito.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {
	
	private BigDecimal valor;
	private SituacaoOrcamento situacao;
	private List<Orcavel> itens;
	
	// Construtor
	public Orcamento() {
		this.valor = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		this.itens = new ArrayList<>();
		this.situacao = new EmAnalise();
	}

	// Getters/Setters
	public BigDecimal getValor() {
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public SituacaoOrcamento getSituacaoOrcamento() {
		return situacao;
	}
		
	public void setSituacaoOrcamento(SituacaoOrcamento situacaoOrcamento) {
		this.situacao = situacaoOrcamento;
	}

	
//	public void adicionarItens(Material item) {
//		this.itens.add(item);
//	}
	
	// Métodos
	public void descontoExtra ( ) {
		BigDecimal valorDescontoExtra = this.situacao.calcularValorDesconto(this); 
		this.valor = this.valor.subtract(valorDescontoExtra).setScale(2, RoundingMode.HALF_UP);
	}
	
	public void aprovar() {
		this.situacao.aprovar(this);
	}

	public void reprovar() {
		this.situacao.reprovar(this);
	}

	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public boolean isFinalizado() {
		return situacao instanceof Finalizado;
	}
	
	public void adicionarItens(Orcavel item) {
		this.valor = valor.add(item.getValor()).setScale(2, RoundingMode.HALF_UP);
		this.itens.add(item);
	}
		
}
