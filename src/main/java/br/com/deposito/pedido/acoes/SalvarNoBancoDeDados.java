package br.com.deposito.pedido.acoes;

import br.com.deposito.pedido.Pedido;

public class SalvarNoBancoDeDados implements AcoesAposGerarPedido {
	
	public void executeAcao(Pedido pedido) {
		System.out.println("Salvou no banco de dados");
	}
	
}
