package javacore.ZZGconcorrencia.app;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest01 {
//Se a queue estiver em sua capacidade máxima , a thread esperar até que tenha espaço
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		bq.put("Matheus");
		System.out.printf("%s adicionou um valor: %s%n" , Thread.currentThread().getName(), bq.peek());
		System.out.println("Tentando adicionar outro valor");
		new Thread(new RemoveFromQueue(bq), "Removedor").start();
		bq.put("Cleiton");
		System.out.printf("%s adicionou um valor: %s%n" , Thread.currentThread().getName(), bq.peek());

	}
	

}
class RemoveFromQueue implements Runnable{
	private final BlockingQueue<String> bq;
	
	
	public RemoveFromQueue(BlockingQueue<String> bq) {
		super();
		this.bq = bq;
	}


	@Override
	public void run() {
		System.out.printf("%s dormindo por 5s%n" , Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
			System.out.printf("%s removeu o valor: %s%n" , Thread.currentThread().getName(), bq.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
