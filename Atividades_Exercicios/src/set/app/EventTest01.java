package set.app;

import set.model.EventManagement;
import set.model.Participant;

public class EventTest01 {

	public static void main(String[] args) {
		Participant p1 = new Participant("Matheus" , "matheus@gmail.com", false);
		Participant p2 = new Participant("Pedro", "pedro@gmail.com", true);
		Participant p3 = new Participant("Maria", "maria@gmail.com", false);
		Participant p4 = new Participant("Sabrina", "sabrina@gmail.com", true);
		Participant p5 = new Participant("João", "joão@gmail.com", true);
		
		EventManagement evento1 = new EventManagement(3);
		
		evento1.registerParticipant(p2);
		evento1.registerParticipant(p1);
		evento1.registerParticipant(p5);
		
		evento1.confirmAttendance(p2);
		evento1.confirmAttendance(p1);
		evento1.confirmAttendance(p5);
		
		evento1.displayConfirmedParticipants();
		
		evento1.registerParticipant(p4);
		evento1.confirmAttendance(p4);
		evento1.displayWaitParticipants();
		
		
		evento1.inviteParticipant(p3);
		evento1.displayInvetedParticipants();

	}

}
