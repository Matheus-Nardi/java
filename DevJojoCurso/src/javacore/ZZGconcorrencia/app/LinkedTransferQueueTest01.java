package javacore.ZZGconcorrencia.app;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
	public static void main(String[] args) throws InterruptedException { 
		TransferQueue<Object> tq = new LinkedTransferQueue<Object>();
		System.out.println(tq.remainingCapacity());
		System.out.println(tq.add("Mateus")); // Add lança execção
		System.out.println(tq.offer("Perola")); // Offer retorna boolean
		tq.offer("Xeila" , 1, TimeUnit.SECONDS);
		tq.put("Arroz");
		if(tq.hasWaitingConsumer()) { //Verifica se há algum consumidor esperando
			tq.transfer("Matheus"); // Bloqueia a thread e espere até que outra thread pege o valor passado
			
		}
		
		System.out.println(tq.tryTransfer("Arroz", 3 , TimeUnit.SECONDS));
		System.out.println(tq.element()); //Retorna a primeira posição e não remove , se tiver vazia retorna uma execão
		System.out.println(tq.poll()); // Retorna null
		System.out.println(tq.remove()); // Retorna expetion
		System.out.println(tq.take()); // Retorna e remove e espera um novo valor a ser colocado
	}
}
