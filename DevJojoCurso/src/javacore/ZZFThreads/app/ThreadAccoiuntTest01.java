package javacore.ZZFThreads.app;

import javacore.ZZFThreads.model.Account;

public class ThreadAccoiuntTest01 implements Runnable {
	private Account account = new Account();

	public static void main(String[] args) throws InterruptedException {
		ThreadAccoiuntTest01 threadAccountTest01 = new ThreadAccoiuntTest01();
		Thread t1 = new Thread(threadAccountTest01, "Matheus");
		Thread t2 = new Thread(threadAccountTest01, "Maria");

		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			withdrawal(10);
			if (account.getBalance() < 0) {
				System.out.println("Deu ruim !");
			}
		}

	}

	// Permitir apenas que um thread execute esse metodo, dando um lock
	private synchronized void withdrawal(int ammout) {
		if (account.getBalance() >= ammout) {
			System.out.println(getThreadname() + " está indo sacar dinheiro");
			account.withdrawal(ammout);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getThreadname() + " completou o saque, valor atul: " + account.getBalance());

		} else {
			System.out.println("Saldo insuficente para " + getThreadname() + " realizar o saque " + account.getBalance());
		}
	}

	private String getThreadname() {
		return Thread.currentThread().getName();
	}

}
