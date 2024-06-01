package javacore.ZZGconcorrencia.app;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class CallableTest01 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RandomNumberCallable callable = new RandomNumberCallable();
		ExecutorService exeService = Executors.newFixedThreadPool(2);
		Future<String> submitFuture = exeService.submit(callable); //Retorna um future , resposta que depende do scheduele
		String string = submitFuture.get(); // Faz a main esperar até obter o resultado
		System.out.printf("Fim , %s" , string);
		exeService.shutdown();
	}
}


class RandomNumberCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		int nextInt = ThreadLocalRandom.current().nextInt(1,11);
		for (int i = 0; i < nextInt; i++) {
			System.out.printf("%s executando call...%n" , Thread.currentThread().getName());
		}
		return String.format("%s terminou a execução e o numero aleatório era : %d" , Thread.currentThread().getName(), nextInt);
	}
	
}
