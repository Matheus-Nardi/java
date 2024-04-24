package models.enumns;

import java.util.Scanner;

public enum ClassificacaoIdade {
	INFANTIL(1, "Infatil"), JUVENIL(2, "Juvenil"), ADULTO(3, "Adulto");

	private Integer indice;
	private String classificacao;

	private ClassificacaoIdade(Integer indice, String classificacao) {
		this.indice = indice;
		this.classificacao = classificacao;
	}

	public Integer getIndice() {
		return indice;
	}

	public String getClassificacao() {
		return classificacao;
	}
	
	
	public static ClassificacaoIdade getByIndice(Integer indice) {
		for (ClassificacaoIdade classificacao : values()) {
			if(classificacao.getIndice() == indice)
				return classificacao;
		}
		return null;
	}
	
	
	public static ClassificacaoIdade escolherClassificacao() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe a classificação: ");
		for (ClassificacaoIdade classificacao : values()) {
			System.out.println(classificacao.getIndice() + " - " + classificacao.getClassificacao());
		}

		return ClassificacaoIdade.getByIndice(scan.nextInt());
				
	}
	
	
	
	
	

}
