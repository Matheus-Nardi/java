package polimorfismo.service;

import polimorfismo.repository.Repository;

public class RepositoryBancoDeDados implements Repository {

	@Override
	public void salvar() {
		System.out.println("Save in a database");
		
	}

}
