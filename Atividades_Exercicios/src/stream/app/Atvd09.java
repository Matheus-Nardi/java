package stream.app;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import stream.model.Employer;
import stream.repository.EmployerRepository;

public class Atvd09 {
	private static List<Employer> employers = EmployerRepository.getEmployers();
	public static void main(String[] args) {
		//Resumo estatico dos salarios 
		
	DoubleSummaryStatistics collect	= employers.stream()
			.collect(Collectors.summarizingDouble(Employer::getSalary));
	
	System.out.println((collect.getMax()));
	System.out.println(collect);
	
	   //Emails do funcionario separados por virgula 
	String emails = employers.stream()
					.map(Employer::getEmail)
					.collect(Collectors.joining(", ", "[", "]"));
	
	System.out.println(emails);
	}
}
