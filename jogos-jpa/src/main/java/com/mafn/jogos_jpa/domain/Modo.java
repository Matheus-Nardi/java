package com.mafn.jogos_jpa.domain;

public enum Modo {
	SINGLEPLAYER,MULTIPLAYER;
	
	
	public static Modo valueOfOrdinal(Integer id) {
		for (Modo modo : Modo.values()) {
			if(modo.ordinal() == id)
				return modo;
		}
		
		throw new IllegalArgumentException();
		
	}
}
