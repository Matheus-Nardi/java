package com.mafn.jogos_jpa.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_seq")
	@SequenceGenerator(name = "jogo_seq", sequenceName = "jogo_seq", allocationSize = 1)
	private Long id;
	private String nome;
	private Double preco;
	private LocalDate dataLancamento;

	@ManyToOne()
	@JoinColumn(name = "desenvolvedor_id")
	private Desenvolvedor desenvolvedor;

	@ManyToMany()
	private List<Genero> generos;
	
	@Enumerated(EnumType.STRING)
	private Modo modo;

	@Builder
	public static Jogo createJogo(Long id, String nome, Double preco, LocalDate dataLancamento,
			Desenvolvedor desenvolvedor, List<Genero> generos, Modo modo) {
		Jogo jogo = new Jogo();
		jogo.id = id;
		jogo.nome = nome;
		jogo.preco = preco;
		jogo.dataLancamento = dataLancamento;
		jogo.desenvolvedor = desenvolvedor;
		jogo.modo = modo;
		jogo.generos = (generos != null) ? generos : new ArrayList<>();
		return jogo;
	}

	public void adiconarGenero(Genero genero) {
		if (genero != null && !getGeneros().contains(genero)) {
			this.getGeneros().add(genero);

			if (!genero.getJogos().contains(this))
				genero.getJogos().add(this);

		}

	}
}
