package br.com.deposito.pedido.acoes;

import br.com.deposito.pedido.Pedido;

public class EnviarEmailPedido implements AcoesAposGerarPedido {

	public void executeAcao(Pedido pedido) {
		System.out.println("Email enviado");
	}

}
