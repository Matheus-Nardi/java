package generics.app;

import java.util.HashMap;
import java.util.Map;

import generics.model.Item;
import generics.model.Livro;
import generics.model.Revista;
import generics.service.Armazem;


public class ArmazemItens {
	public static void main(String[] args) {
		Armazem<Item> armazemLivro = new Armazem<Item>();
		Map<Integer,Item> itemLivro = new HashMap<>();
		
		itemLivro.put(1, new Livro("Romeu e Julieta", 50.90, "Shakespere"));
		itemLivro.put(2, new Livro("O poder da mente", 125.90, "Pablo Marçal"));
		itemLivro.put(3, new Livro("A arte da guerra", 30.90, "Sun Tzu"));
		
		armazemLivro.adicionarItem(itemLivro.get(1));
		armazemLivro.adicionarItem(itemLivro.get(2));
		armazemLivro.buscarItem(itemLivro.get(3));
		armazemLivro.mostrarItens();
		
		Armazem<Item> armazemRevista = new Armazem<Item>();
		Map<Integer,Item> itemRevista = new HashMap<>();
		
		itemRevista.put(1, new Revista("Aquecimento global", 50.90, "THE WORLD"));
		itemRevista.put(2, new Revista("Porque o macaco come banana ?", 125.90, "SuperInteressante"));
		itemRevista.put(3, new Revista("Vista preto", 30.90, "VOGUE"));
		
		armazemRevista.adicionarItem(itemRevista.get(2));
		
		
		
	}
}
