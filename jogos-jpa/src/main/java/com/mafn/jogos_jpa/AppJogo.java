package com.mafn.jogos_jpa;

import java.util.Scanner;

import com.mafn.jogos_jpa.service.NavegarService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppJogo {
	private final static Scanner SCAN = new Scanner(System.in);

	public static void main(String[] args) {
			NavegarService navegarService = new NavegarService();
			navegarService.navegar();
	}
	
	

}
