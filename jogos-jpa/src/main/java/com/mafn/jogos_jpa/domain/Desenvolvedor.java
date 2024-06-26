package com.mafn.jogos_jpa.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Desenvolvedor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "desenvolvedor_seq")
	@SequenceGenerator(name = "desenvolvedor_seq", sequenceName = "desenvolvedor_seq", allocationSize = 1)
	private Long id;
	private String nome;
	private String urlSite;
	
	@OneToMany(mappedBy = "desenvolvedor" , fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<Jogo> jogos;
}
