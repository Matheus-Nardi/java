package stream.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import stream.model.Departament;
import stream.model.Employer;

public class EmployerRepository {

	private static List<Employer> employers = new ArrayList<Employer>(
			Arrays.asList(new Employer(1, "Wally", "wally@gmail.com", 2500.00, 23, Departament.DEV),
					new Employer(2, "Heitor", "heitor@hotmail.com", 2300.00, 22,Departament.RH),
					new Employer(3, "Lilia", "li@gmail.com", 2100.00, 27,Departament.DESINGER),
					new Employer(4, "Alonso", "alonso@gmail.com", 2350.00, 34,Departament.DEV),
					new Employer(5, "Mary", "mary@gmail.com", 2250.00, 37,Departament.RH),
					new Employer(6, "Cristine", "critine@yahoo.com", 2100.00, 22,Departament.DESINGER),
					new Employer(7, "Marco", "marco@gmail.com", 2750.00, 27,Departament.DEV),
					new Employer(8, "Elsen", "eslen@gmail.com", 2550.00, 34,Departament.DESINGER)));

	public static List<Employer> getEmployers() {
		return employers;
	}
}
