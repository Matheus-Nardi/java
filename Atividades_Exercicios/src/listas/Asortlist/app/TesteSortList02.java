package listas.Asortlist.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import listas.Asortlist.modelo.Produto;

public class TesteSortList02 {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		produtos.add(new Produto("Garrafa térmica", 199.99, true));
		produtos.add(new Produto("Chaveiro do flamengo", 9.99, false));
		produtos.add(new Produto("Batata Rufles 100g", 12.50, true));
		produtos.add(new Produto("Batata Doritos 90g", 12.50, false));
		produtos.add(new Produto("Coca-Cola 1L", 6.00, true));
		
		Collections.sort(produtos);
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

}
