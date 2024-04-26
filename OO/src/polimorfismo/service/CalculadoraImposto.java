package polimorfismo.service;

import polimorfismo.models.Abacate;
import polimorfismo.models.Produto;

public class CalculadoraImposto {
	public static void calcularImpostoProduto(Produto produto) {
		System.out.println("Relatorio de taxação");
		System.out.println("Produto: " + produto.getNome() + " - " +  produto.getValor());
		System.out.println("Valor imposto: " + produto.calcularImposto());
		if(produto instanceof Abacate)
			((Abacate)produto).getDataValidade();
			
		
	}
}
