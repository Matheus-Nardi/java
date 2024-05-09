package javacore.Ycolecoes.app;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import javacore.Ycolecoes.models.Consumidor;

class ConsumidorById implements Comparator<Consumidor>{

	@Override
	public int compare(Consumidor o1, Consumidor o2) {
		return o1.getId().compareTo(o2.getId());
	}
	
}
public class QueueTest01 {

	public static void main(String[] args) {
		//FIFO , fisrt in first out 
		//Ter um comparable ou comparator
		//A priority quee dar prioridade ao comparable e não a ordem de inserção
		Queue<Consumidor> fila = new PriorityQueue<Consumidor>(new ConsumidorById().reversed());
		fila.add(new Consumidor("Marcelinho"));
		fila.add(new Consumidor("Ronaldo"));
		fila.add(new Consumidor("Sheilane"));
		fila.add(new Consumidor("Hugo"));

		while(!fila.isEmpty()) {
			System.out.println("Removendo: " + fila.poll());
		}
		
		System.out.println("Tamanho: " + fila.size());
		
		
		
	
	}

}
