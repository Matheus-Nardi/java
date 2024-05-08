package set.model;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class EventManagement {
	private Integer vagas;
	private Set<Participant> participants ;
	private Set<Participant> confirmParticipants ;
	private NavigableSet<Participant> waitParticipants;
	
	public EventManagement(Integer vagas) {
		this.vagas = vagas;
		participants = new HashSet<Participant>();
		confirmParticipants = new HashSet<Participant>();
		waitParticipants = new TreeSet<Participant>();
	}
	public void registerParticipant(Participant participant) {
		participants.add(participant);
		System.out.println("Participante adicionado");
	}
	
	public void confirmAttendance(Participant participant) {
		if(confirmParticipants.size() < vagas) {
			confirmParticipants.add(participant);
			System.out.println("Participante adicionado a lista de confirmados");
			participant.setStatusConfirmação(true);
		}else {
			waitParticipants.add(participant);
			System.out.println("Participante adicionado a lista de espera");
		}
	}
	
	public void cancelAttendance(Participant participant) {
		if(confirmParticipants.contains(participant))
			confirmParticipants.remove(participant);
		else if(waitParticipants.contains(participant))
			waitParticipants.remove(participant);
		else
			System.out.println("O participante não está cadastastrado");
	}
	
	public void inviteParticipant(Participant participant) {
		participants.add(participant);
	}
	
	public void displayConfirmedParticipants() {
		for (Participant participant : confirmParticipants) {
			System.out.println(participant);
		}
	}
	
	public void displayWaitParticipants() {
		for (Participant participant : waitParticipants) {
			System.out.println(participant);
		}
	}
	
	public void displayInvetedParticipants() {
		for (Participant participant : participants) {
			System.out.println(participant);
		}
	}
	
}
