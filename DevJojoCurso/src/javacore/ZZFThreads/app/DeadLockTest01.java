package javacore.ZZFThreads.app;

public class DeadLockTest01 {
	public static void main(String[] args) {
		
		//DeadLock: uma thread prrecisa acessar um objeto que já esta sendo processado por outra thread
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Runnable r1 = () -> {
			synchronized (lock1) {
				System.out.println("Thread 1: Segurando lock 1");
				System.out.println("Thread 1: Esperando lock 2");
				synchronized (lock2) {
					System.out.println("Thread 1: Segurando lock 2");
				}
			}
		};
		Runnable r2 = () -> {
			synchronized (lock2) {
				System.out.println("Thread 2: Segurando lock 2");
				System.out.println("Thread 2: Esperando lock 1");
				synchronized (lock1) {
					System.out.println("Thread 2: Segurando lock 1");
				}
			}
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
