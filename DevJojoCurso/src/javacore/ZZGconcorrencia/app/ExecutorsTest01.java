package javacore.ZZGconcorrencia.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest01 {

	public static void main(String[] args) {
		// Desaclopar tarefa
		ExecutorService executorService = Executors.newFixedThreadPool(4); // pool de threads fixa
		ExecutorService executorService2 = Executors.newSingleThreadExecutor(); // pool de threads unica
		ExecutorService executorService3 = Executors.newCachedThreadPool(); // pool de threads que é reutilizada

		executorService.execute(new Printer(1));
		executorService.execute(new Printer(2));
		executorService.execute(new Printer(3));
		executorService.execute(new Printer(4));
		executorService.execute(new Printer(5));
		executorService.execute(new Printer(6));

		executorService.shutdown();
		System.out.println("Fim do programa !");
	}

}

class Printer implements Runnable {
	private final int num;

	public Printer(int num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		System.out.printf("%s inicio: %d%n", Thread.currentThread().getName(), num);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s finalizou%n", Thread.currentThread().getName());
	}

}
