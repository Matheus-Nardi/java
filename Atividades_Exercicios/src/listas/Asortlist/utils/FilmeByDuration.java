package listas.Asortlist.utils;

import java.util.Comparator;

import listas.Asortlist.modelo.Filme;

 public class FilmeByDuration implements Comparator<Filme> {

	@Override
	public int compare(Filme o1, Filme o2) {
		return o2.getDuração().compareTo(o1.getDuração());
	}

}