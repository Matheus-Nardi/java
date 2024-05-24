package javacore.ZZGconcorrencia.app;

import javax.swing.JOptionPane;

import javacore.ZZGconcorrencia.model.Members;
import javacore.ZZGconcorrencia.service.EmailDeliveryService;


public class EmailDeliveryTest01 {
	public static void main(String[] args) {
		Members mebers = new Members();
		Thread thread = new Thread(new EmailDeliveryService(mebers), "Devzada");
		Thread thread2 = new Thread(new EmailDeliveryService(mebers), "Java");

		thread.start();
		thread2.start();
		while (true) {
			String email = JOptionPane.showInputDialog("Entre com seu email");
			if (email == null || email.isEmpty()) {
				mebers.close();
				break;
			}

			mebers.addMemberEmail(email);
		}

	}
}
