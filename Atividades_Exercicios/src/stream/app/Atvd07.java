package stream.app;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import stream.model.Product;

public class Atvd07 {
	public static void main(String[] args) {
		/*
		 * filtrar os produtos com preço superior a 25 e conte quantos produtos
		 * correspondem a esse critério. 
		 * ordene-os pelo nome em ordem alfabética. Em
		 * seguida, colete os nomes dos produtos ordenados em uma lista.
		 *  agrupe-os por
		 * faixas de preço (por exemplo, produtos de preço abaixo de 25, entre 25 e 40,
		 * e acima de 100). Imprima os grupos e a quantidade de produtos em cada grupo.
		 */

		List<Product> products = List.of(new Product("Oléo", 12.99), new Product("Arroz", 31.20),
				new Product("Feijao", 10.14), new Product("Alcatra", 39.99), new Product("Sabão 3kg", 32.77));

		System.out.println("Qtd produto com preço > 25: " + products.stream().filter(p -> p.getPrice() > 25).count());
		List<Product> sortName = products.stream()
			.sorted(Comparator.comparing(Product::getName))
			.collect(Collectors.toList());
		
		System.out.println("Ordem default");
		products.forEach(System.out::println);
		
		System.out.println("Em ordem alfabética");
		sortName.forEach(System.out::println);
		
	}
}
