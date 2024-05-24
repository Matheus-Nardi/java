package javacore.ZZGconcorrencia.app;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicIntegerTest01 {
	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();

		Runnable r = () -> {
			for (int i = 0; i < 10000; i++) {
				c.increment();
			}
		};

		Thread t1 = new Thread(r, "TH1");
		Thread t2 = new Thread(r, "TH2");

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(c.getCount());
		System.out.println(c.getAtomicInteger());
	}
}
//Fair == true , passa para a therad que está esperando a mais tempo
//Lock deixa um código mais poluido, porem + controle
class Counter {
	private int count;
	private AtomicInteger atomicInteger = new AtomicInteger(); //Faz com que não ocorra o lock da thered para ter contar
	private Lock lock = new ReentrantLock(true); //Diferente do sincronizado te da mais controle
	void increment() {
		//lock.tryLock(3, TimeUnit.SECONDS);
		lock.lock(); //Obter o lock 
		try {
			count++;
			atomicInteger.incrementAndGet();	
		}finally {
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}
	
	public AtomicInteger getAtomicInteger() {
		return atomicInteger;
	}
}
