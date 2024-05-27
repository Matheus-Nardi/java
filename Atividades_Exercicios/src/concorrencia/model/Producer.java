package concorrencia.model;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<Pedido> queuePedidos;

	public Producer(BlockingQueue<Pedido> queuePedidos) {
		super();
		this.queuePedidos = queuePedidos;
	}

	@Override
	public void run() {
		try {
			addPedido();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void addPedido() throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			String detalhes = "Pedido " + (i+1);
			queuePedidos.put(new Pedido(detalhes));
			System.out.printf(" O produtor %s adicionou o pedido: %s%n", Thread.currentThread().getName(),
					queuePedidos.peek());
			Thread.sleep(100);
		}
	
	}

}
