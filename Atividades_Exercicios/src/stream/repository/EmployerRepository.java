package stream.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import stream.model.Employer;

public class EmployerRepository {

	private static List<Employer> employers = new ArrayList<Employer>(
			Arrays.asList(new Employer(1, "Wally", "wally@gmail.com", 2500.00, 23),
					new Employer(2, "Heitor", "heitor@hotmail.com", 2300.00, 22),
					new Employer(3, "Lilia", "li@gmail.com", 2100.00, 27)));

	public static List<Employer> getEmployers() {
		return employers;
	}
}
