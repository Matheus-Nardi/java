package com.mafn.jogos_jpa.service;

import com.mafn.jogos_jpa.utils.InputUtils;

public class NavegarService {

    private JogoService jogoService;
    private DesenvolvedorService desenvolvedorService;
    private GeneroService generoService;

    public NavegarService() {
        jogoService = new JogoService();
        desenvolvedorService = new DesenvolvedorService();
        generoService = new GeneroService();
    }

    public void navegarMenu() {
        System.out.println("============");
        System.out.println("[1] JOGO");
        System.out.println("[2] GENERO");
        System.out.println("[3] DESENVOLVEDOR");
        System.out.println("[4] SAIR");
        System.out.println("============");
    }

    public void navegar() {
        boolean continuar = true;
        while (continuar) {
            navegarMenu();
            int opcao = InputUtils.lerInt();
            switch (opcao) {
                case 1 -> jogoService.menuJogo();
                case 2 -> generoService.menuGenero();
                case 3 -> desenvolvedorService.menuDesenvolvedor();
                case 4 -> {
                    continuar = false;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Escolha uma opção válida");
            }
        }
    }
}
