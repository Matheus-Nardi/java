package map.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import map.model.Candidato;

public class TestCandidato01 {
	public static void main(String[] args) {
		Candidato candidatoPalmas = new Candidato("Romero Brito", 45);
		Candidato candidatoPalmas2 = new Candidato("Jaco Souza Melo", 62);
		Candidato candidatoPalmas3 = new Candidato("Marina Seiva D'Agua", 23);
		
		List<Integer> votosC1 = new ArrayList<Integer>(Arrays.asList(23 , 19 , 25 , 4));
		List<Integer> votosC2 = new ArrayList<Integer>(Arrays.asList(23 , 15 , 26 , 6));
		List<Integer> votosC3 = new ArrayList<Integer>(Arrays.asList(27 , 20 , 22 , 3));
		
		
		Map<Candidato , List<Integer>> mapCandidatoVotos = new HashMap<Candidato, List<Integer>>();
		mapCandidatoVotos.put(candidatoPalmas, votosC1);
		mapCandidatoVotos.put(candidatoPalmas2, votosC2);
		mapCandidatoVotos.put(candidatoPalmas3, votosC3);
		
		 Map.Entry<Candidato, List<Integer>> candidatoVencedorEntry = candidatoVencedor(mapCandidatoVotos);
		 Candidato vencedor = candidatoVencedorEntry.getKey();
         List<Integer> votosVencedor = candidatoVencedorEntry.getValue();
         System.out.println("O candidato vencedor é: " + vencedor.getNome());
         System.out.println("Com um total de votos de: " + calcularTotalVotos(votosVencedor));
		
	}
	
	public static int calcularTotalVotos(List<Integer> votos) {
		int total = 0 ;
		for (Integer voto : votos) {
			total += voto;
		}
		
		return total;
	}
	
	
	 public static Map.Entry<Candidato, List<Integer>> candidatoVencedor(Map<Candidato, List<Integer>> mapCandidato) {
	        Map.Entry<Candidato, List<Integer>> vencedorEntry = null;
	        int maiorQtdVoto = 0;
	        for (Map.Entry<Candidato, List<Integer>> entry : mapCandidato.entrySet()) {
	            int totalVotos = calcularTotalVotos(entry.getValue());
	            if (totalVotos > maiorQtdVoto) {
	                maiorQtdVoto = totalVotos;
	                vencedorEntry = entry;
	            }
	        }
	        return vencedorEntry;
	    }
}
