package stream.app;

import java.util.Comparator;
import java.util.List;

import stream.model.Employer;
import stream.repository.EmployerRepository;

public class Atvd08 {
	public static void main(String[] args) {
		//Revisão
		List<Employer> employers = EmployerRepository.getEmployers();
		//Média salarial da empresa
		 	employers.stream()
			.mapToDouble(Employer::getSalary)
			.average()
			.ifPresent(System.out::println);
		 	
		//Qtd de funcionarios que usam gmail
		Long qtdGmail = employers.stream()
		 	.map(Employer::getEmail)
		 	.filter(email -> email.contains("@gmail"))
		 	.count();
		System.out.println("Funcionarios que usam gmail: " + qtdGmail);
		
		//Funcionario mais melho e mais novo 
		//1 forma com max
			employers.stream()
			.max(Comparator.comparing(Employer::getIdade))
			.ifPresent(System.out::println);;
		
		// 2 forma com reduce
		employers.stream()	
			.mapToInt(Employer::getIdade)
			.reduce(Integer::max)
			.ifPresent(System.out::println);
		
		employers.stream()
			.min(Comparator.comparing(Employer::getIdade))
			.ifPresent(System.out::println);
		
		//Aumento salariao 
		employers.stream()
			.forEach(em -> em.setNewSalaray(0.2));
		
		employers.forEach(System.out::println);
		
		//Todos funcionarios ganham mais de 2300 ? 
		System.out.println("Todos funcionarios ganham mais de 2600 ? " + employers.stream()
			.allMatch(em -> em.getSalary() > 2600));
		
		//Porcentagem de pessoas que não usam gmail
			Long qtdOutroemail = employers.stream()
			.filter(em -> !(em.getEmail().contains("@gmail.com")))
			.count();
			Double porcem = (qtdOutroemail.doubleValue()/employers.size()) * 100;
			System.out.println(porcem);
		
		
		
	}
	
}
