package com.mafn.jogos_jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Desenvolvedor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "desenvolvedor_seq")
	@SequenceGenerator(name = "desenvolvedor_seq", sequenceName = "desenvolvedor_seq", allocationSize = 1)
	private Long id;
	private String nome;
	private String urlSite;
}
