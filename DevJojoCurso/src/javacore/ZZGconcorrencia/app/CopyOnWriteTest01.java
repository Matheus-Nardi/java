package javacore.ZZGconcorrencia.app;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

//Objeto imutavel : não permite alterações de valores
//Cemario em que as leituras > escritas
public class CopyOnWriteTest01 {
	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList<>(); //Lista é imutavel, mas ao adiconar elementos os mesmos devem ser imutaveis
		// 1 
		// Para adiconar 2 , cria uma nova lista , com 1 e 2 
		
		for (int i = 0; i < 2000; i++) {
			list.add(i);
		}
		
		Runnable runnableIterator = () -> {
			Iterator<Integer> iterator = list.iterator();
			try {
				TimeUnit.SECONDS.sleep(2);
				iterator.forEachRemaining(System.out::println);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable runnableRemove = () -> {
			for (int i = 0; i < 500; i++) {
				System.out.printf("%s removed %d%n" , Thread.currentThread().getName(), i);
				list.remove(i);
			}
		};
		
		new Thread(runnableIterator).start();
		new Thread(runnableIterator).start();
		new Thread(runnableRemove).start();
	}
}

//Exemplo de obj imutavel
final class Anime {
	private final String name;

	public Anime(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
