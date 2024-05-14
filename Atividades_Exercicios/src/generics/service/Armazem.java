package generics.service;

import java.util.ArrayList;
import java.util.List;

public class Armazem<T> {
	
	private List<T> itens;
	
	public Armazem() {
		itens = new ArrayList<T>();
	}
	
	public void adicionarItem(T item){
		itens.add(item);
	}
	
	public void removeritem(T item) {
		itens.remove(item);
	}
	
	public void buscarItem(T item) {
		if(itens.contains(item)) {
			System.out.println("Objeto encontrado");
		}else {
			System.out.println("Objeto " + item + " não está na lista");
		}
	}
	public void mostrarItens() {
		for (T t : itens) {
			System.out.println(t);
		}
	}
}
