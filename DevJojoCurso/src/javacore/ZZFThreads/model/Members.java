package javacore.ZZFThreads.model;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
	private final Queue<String> emails = new ArrayBlockingQueue<String>(10);
	
	private boolean open = true;
	
	
	public boolean isOpen() {
		return open;
	}
	
	public int pendingEmails() {
		synchronized (emails) {
			return emails.size();
		}
	}
	
	public void addMemberEmail(String email) {
		synchronized (this.emails) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " Adicionou email na lista");
			this.emails.add(email);
			this.emails.notifyAll();
		}
	}
	
	//Somente ter um wait se tiver um bloco/metodo sincronizado
	public String retriveEmail() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "checking if there are emails");
		synchronized (this.emails) {
			while(this.emails.size() == 0) {
				if(!open) return null;
				System.out.println(Thread.currentThread().getName() + " Não tem email disponível, entrando no modo de espera");
				this.emails.wait();
			}
			
			return this.emails.poll();
		}
	}
	
	public void close() {
		open = false;
		synchronized (emails) {
			System.out.println(Thread.currentThread().getName() + " Notificando todos que não estamos mais recebendo emails");	
		}
	}
}
