package listas.Asortlist.utils;

import java.util.Comparator;

import listas.Asortlist.modelo.Filme;

public class FilmeByLaunchDate implements Comparator<Filme> {

	@Override
	public int compare(Filme o1, Filme o2) {
		return o2.getDataLancamento().compareTo(o1.getDataLancamento());
	}

}
