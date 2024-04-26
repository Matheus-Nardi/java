package polimorfismo.app;

import polimorfismo.repository.Repository;
import polimorfismo.service.RepositoryBancoDeDados;
import polimorfismo.service.RepositoryFile;

public class RepositoryTeste {

	public static void main(String[] args) {
		
		Repository repo = new RepositoryFile();
		repo.salvar();

	}

}
