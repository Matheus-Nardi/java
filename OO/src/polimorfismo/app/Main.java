package polimorfismo.app;

import polimorfismo.models.Abacate;
import polimorfismo.models.Computador;
import polimorfismo.models.Produto;
import polimorfismo.service.CalculadoraImposto;

public class Main {

	public static void main(String[] args) {
		Produto p = new Computador("ACERi5 ASPIRE" , 3550.00); // isso é polimorfismo , mutiplas formas
		Abacate p2 = new Abacate("Abacate Grego" , 12.99);
		p2.setDataValidade("23/08/2024");
		
		Computador computador = new Computador("NUC10i7", 11000.);
		Abacate abacate = new Abacate("Abacate Ingles", 8.45);
		
		CalculadoraImposto.calcularImpostoProduto(computador);
		System.out.println("-----------------");
		CalculadoraImposto.calcularImpostoProduto(p2);
		
		

	}

}
