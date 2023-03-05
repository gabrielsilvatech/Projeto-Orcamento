package br.com.deposito.pedido;

import java.time.LocalDateTime;

import br.com.deposito.orcamento.Orcamento;

public class Pedido {
	String cliente;
	LocalDateTime data;
	Orcamento orcamento;
	
	public Pedido(String cliente, LocalDateTime data, Orcamento orcamento) {
		
		this.cliente = cliente;
		this.data = data;
		this.orcamento = orcamento;
	
	}
		
	public String getCliente() {
		return cliente;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	
}
