package stream.app;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import stream.model.Departament;
import stream.model.Employer;
import stream.repository.EmployerRepository;

public class Atvd10 {
	public static void main(String[] args) {
		List<Employer> employers = EmployerRepository.getEmployers();
		
		//Agrupar os funcionarios por Departamento 
		Map<Departament, List<Employer>> collect = employers.stream()
			.collect(Collectors.groupingBy(Employer::getDepartament));
		
		for (Map.Entry<Departament, List<Employer>> entry : collect.entrySet()) {
			Departament departament = entry.getKey();
			List<Employer> employerByDepartament = entry.getValue();
			
			System.out.println(departament);
			for (Employer employer : employerByDepartament) {
				System.out.println(" - " + employer.getName());
			}
		}
		
		//Agrupar por departamento e quantidade
		Map<Departament, Long> collectCount = employers.stream()
			.collect(Collectors.groupingBy(Employer::getDepartament, Collectors.counting()));
		
		System.out.println(collectCount);
		
		//Media salaria por categoria
		Map<Departament, Double> collectSalaryByCategory = employers.stream()
			.collect(Collectors.groupingBy(Employer::getDepartament,
						Collectors.averagingDouble(Employer::getSalary)));
		
		for (Map.Entry<Departament, Double> entry : collectSalaryByCategory.entrySet()) {
			System.out.printf("Departamento: %s - Media Salarial: %.2f \n" , entry.getKey().name(), entry.getValue());
		}
		
		//Estasticas gerais por departamento
			Map<Departament, DoubleSummaryStatistics> collectSummarizing = employers.stream()
				.collect(Collectors.groupingBy(Employer::getDepartament, Collectors.summarizingDouble(Employer::getSalary)));
			
			System.out.println(collectSummarizing);
			
			
	}
}
