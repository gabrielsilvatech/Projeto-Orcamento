package br.com.deposito.material;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.deposito.orcamento.Orcavel;

public class Material implements Orcavel{
		
	private BigDecimal valor;

	
	public Material(BigDecimal preco) {
		this.valor = preco.setScale(2, RoundingMode.HALF_UP);		
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}
