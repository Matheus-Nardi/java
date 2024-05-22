package javacore.ZZFThreads.app;

public class ThreadTest02 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadExampleRunnable2("KA"), "T1");
		Thread t2 = new Thread(new ThreadExampleRunnable2("ME"), "T2");
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t1.join(); 
		System.out.println("\nT1 terminou seu processo");
		//t1.join(1000); a thread tem 1s para executar o que seja
		t2.start();
		System.out.println("\nT2 terminou seu processo");
		
		//Yield : fazer com que a thread saia do estado running para runnable
		//Join: fazer com que a thread atual , espere até que aquela que teve o join chamado, termine sua execução
	}

}

class ThreadExampleRunnable2 implements Runnable {
	private final String c;

	public ThreadExampleRunnable2(String c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 500; i++) {
			System.out.print(c);
			if (i % 100 == 0)
				System.out.println();

//			try {
//				Thread.sleep(0);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}
