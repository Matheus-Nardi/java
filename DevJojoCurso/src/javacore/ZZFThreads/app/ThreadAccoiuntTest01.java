package javacore.ZZFThreads.app;

import javacore.ZZFThreads.model.Account;

public class ThreadAccoiuntTest01 implements Runnable{
	private Account account = new Account();
	public static void main(String[] args) {
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
			if(account.getBalance() < 0) {
				System.out.println("Deu ruim !");
			}
		}
		
	}
	private void withdrawal(int ammout) {
		if(account.getBalance() >=ammout) {
			System.out.println(getThreadname() + "está indo sacar dinheiro");
			account.withdrawal(ammout);
			System.out.println(getThreadname() + "completou o saque, valor atul: " + account.getBalance());
			
		}else {
			System.out.println("Saldo insuficente para " + getThreadname() + " realizar o saque " +account.getBalance() );
		}
	}

	private String getThreadname() {
		return Thread.currentThread().getName();
	}

}
