package javacore.ZZGconcorrencia.app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
	private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static void beeper() {
		Runnable r  = () -> {
			System.out.println(LocalTime.now().format(format) + " beep");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		//executor.schedule(r, 5, TimeUnit.SECONDS); //Executa uma unica vez
		ScheduledFuture<?> scheduleAtFixedRate = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS); //Executa a cada 5seg e quando a thread dorme ele ja tenta executar sua tarefa
		//ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS); //Executa a cada 5seg e quando a thread dorme ele soma tempo o seu tempo + tempo de sleep
		executor.schedule(() ->{
			System.out.println("Cancelando...");
			scheduleAtFixedRate.cancel(false);
			executor.shutdown();
		}, 10 , TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		System.out.println(LocalTime.now().format(format));
		beeper();
	}
}
