package br.com.deposito.pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GeraPedido {

	private String cliente;
	private BigDecimal valorOrcamento;
	private int quantidadeItens;
	
	
	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento.setScale(2, RoundingMode.HALF_UP);
		this.quantidadeItens = quantidadeItens;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento.setScale(2, RoundingMode.HALF_UP);
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

}
