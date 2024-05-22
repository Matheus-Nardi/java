package javacore.ZZFThreads.app;

//Daemon x User  
//Encerra quando todos as threads users encerram
public class ThreadsTest01 {
	public static void main(String[] args) {
		/*
		 * ThreadExemple t1 = new ThreadExemple('a'); 
		 * ThreadExemple t2 = new ThreadExemple('b');
		 *  ThreadExemple t3 = new ThreadExemple('c');
		 *   ThreadExemplet4 = new ThreadExemple('d');
		 */
		
		Thread t1 = new Thread(new ThreadExampleRunnable('a'), "T1A");
		Thread t2 = new Thread(new ThreadExampleRunnable('b'), "T2B");
		Thread t3 = new Thread(new ThreadExampleRunnable('c'), "T3C");
		Thread t4 = new Thread(new ThreadExampleRunnable('d'), "T4D");
		
		//Utilizando apenas uma thread
		/*
		 * t1.run(); t2.run(); t3.run(); t4.run();
		 */
		
		//Nesse momento, a uma alternancia na thread | JVM que manda
		t4.setPriority(Thread.MAX_PRIORITY);   //Defifindo prioridade
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		//Nao pode dar start na mesma thread
		
		//Estados
		//New , runnable, running , waiting/blocked , dead
		
	}
}
//é ruim, pois força a ideia da classe SER UMA thread
class ThreadExemple extends Thread{
	private final char c;

	public ThreadExemple(char c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()); //Obtendo nome da nossa thread
		for (int i = 0; i < 500; i++) {
			System.out.print(c);
			if( i % 100 == 0)
				System.out.println();
		}
	}
	
	
}

//faz mais sentido porque essa classe apenas imlementa e não extende
class ThreadExampleRunnable implements Runnable{
	private final char c;

	public ThreadExampleRunnable(char c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()); //Obtendo nome da nossa thread
		for (int i = 0; i < 500; i++) {
			System.out.print(c);
			if( i % 100 == 0)
				System.out.println();
			
			try {
				Thread.sleep(2000);//Colocando thread para dormir 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
