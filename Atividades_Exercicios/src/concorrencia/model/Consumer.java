package concorrencia.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
	private final BlockingQueue<Pedido> queuePedidos;

	public Consumer(BlockingQueue<Pedido> queuePedidos) {
		super();
		this.queuePedidos = queuePedidos;
	}

	@Override
	public void run() {
		try {
			while(true) {
				System.out.printf("%s verificando inventário%n", Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.printf("%s processando pagamento%n", Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.printf("%s preparando pedido para envio%n", Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.printf("%s Sucesso na aplicação do pedido: %s%n", Thread.currentThread().getName(),
						queuePedidos.take());
				System.out.println("Agurando novos pedidos!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
