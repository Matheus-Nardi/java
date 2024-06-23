package com.mafn.jogos_jpa.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "jogo_seq")
	@SequenceGenerator(name = "jogo_seq", sequenceName = "jogo_seq", allocationSize = 1)
	private Long id;
	private String nome;
	private Double preco;
	private LocalDate dataLancamento;
	
	public Jogo(Long id) {
		
	}
}
