package javacore.ZZFThreads.service;

import javacore.ZZFThreads.model.Members;

public class EmailDeliveryService implements Runnable {
	private final Members members;

	public EmailDeliveryService(Members members) {
		this.members = members;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " strating to deliver emails...");
		while (members.isOpen() || members.pendingEmails() > 0) {
			try {
				String email = members.retriveEmail();
				if(email == null) continue;
				System.out.println(name + "enviando email para " + email);
				Thread.sleep(2000);
			
				System.out.println(name + "enviando com sucesso para " + email);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		System.out.println("Todos os emails foram enviados com sucesso");

	}

}
