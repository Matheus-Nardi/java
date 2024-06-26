package com.mafn.jogos_jpa.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_seq")
	@SequenceGenerator(name = "genero_seq", sequenceName = "genero_seq", allocationSize = 1)
	private Long id;

	private String nome;
	@ManyToMany(mappedBy = "generos")
	@ToString.Exclude
	private List<Jogo> jogos = new ArrayList<Jogo>();
	

    @Builder
    public static Genero createGenero(Long id, String nome, List<Jogo> jogos) {
        Genero genero = new Genero();
        genero.id = id;
        genero.nome = nome;
        genero.jogos = (jogos != null) ? jogos : new ArrayList<>();
        return genero;
    }
}
