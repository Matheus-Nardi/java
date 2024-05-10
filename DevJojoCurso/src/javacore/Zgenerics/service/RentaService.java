package javacore.Zgenerics.service;

import java.util.List;

public class RentaService<T> {
	private List<T> objetosDisponiveis;
	
	public RentaService(List<T> objetosDisponiveis) {
		this.objetosDisponiveis = objetosDisponiveis;
	}

	public T mostrarObjetosDisponivel() {
		System.out.println("Buscando carro disponível");
		T t = objetosDisponiveis.remove(0);
		System.out.println("Alugando objeto: " + t);
		System.out.println("Carros disponíveis para alugar: ");
		System.out.println(objetosDisponiveis);

		return t;
	}

	public void retornarObjetoAlugado(T t) {
		System.out.println("Devolvendo objeto:" + t);
		objetosDisponiveis.add(t);
		System.out.println("Objetos disponíveis para alugar: ");
		System.out.println(objetosDisponiveis);
	}
}
