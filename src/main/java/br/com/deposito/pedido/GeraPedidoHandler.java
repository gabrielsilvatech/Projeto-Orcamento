package br.com.deposito.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.deposito.orcamento.Orcamento;
import br.com.deposito.pedido.acoes.AcoesAposGerarPedido;

public class GeraPedidoHandler {
	
	// injeção de dependencias: Salvar no Banco de dados, enviar Email.
		private List<AcoesAposGerarPedido> acoes;
		
	public GeraPedidoHandler(List<AcoesAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento();
		dados.getValorOrcamento(); 
		dados.getQuantidadeItens();
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		acoes.forEach(a -> a.executeAcao(pedido));
	}
	
}
