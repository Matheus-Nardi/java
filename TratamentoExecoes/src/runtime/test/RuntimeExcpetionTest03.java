package runtime.test;

public class RuntimeExcpetionTest03 {

	public static void main(String[] args) {
		//Finally sempre é executado
		openConnection();

	}

	private static void openConnection() {
		try {
			System.out.println("Abrindo arquivo");
			System.out.println("Escrevendo dados do arquivo");
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("Fechando recurso");
		}
	}

}
