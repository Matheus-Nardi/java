package javacore.ZZFThreads.model;

public class Account {
	private int balance = 50;
	
	public void withdrawal(int ammount) {
		 this.balance = this.balance - ammount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	
}
