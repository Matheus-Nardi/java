package javacore.ZZFThreads.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeTest01 {

	public static void main(String[] args) {
		// Thread safe , threads ja sincronizadas
		//Não basta a classe ser safe , os metodos tambem devem ser sincronizados
		ThreadSafeNames threadSafeNames = new ThreadSafeNames();
		threadSafeNames.add("Matheus");

		Runnable r = threadSafeNames::removeFirst;
		new Thread(r, "T1").start();
		new Thread(r, "T2").start();

	}

}

class ThreadSafeNames {
	private final List<String> names = new ArrayList<>();

	public synchronized void add(String name) {
		names.add(name);
	}

	public synchronized void removeFirst() {
		if (names.size() > 0) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(names.remove(0));

		}
	}
}
