package concorrencia.app;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import concorrencia.model.Consumer;
import concorrencia.model.Pedido;
import concorrencia.model.Producer;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<Pedido> bqPedidos = new ArrayBlockingQueue<Pedido>(10);
		
		new Thread(new Producer(bqPedidos), "Producer").start();
		new Thread(new Consumer(bqPedidos), "Consumer 1").start();
		new Thread(new Consumer(bqPedidos), "Consumer 2").start();
		new Thread(new Consumer(bqPedidos), "Consumer 3").start();
		new Thread(new Consumer(bqPedidos), "Consumer 4").start();

	}

}
