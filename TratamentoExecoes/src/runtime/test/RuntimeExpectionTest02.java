package runtime.test;

public class RuntimeExpectionTest02 {

	public static void main(String[] args) {
		System.out.println(divisao(1,0));
	}
	
	//Sempre tentar buscas as mais especificas
	private static int divisao(int a, int b) {
		if(b == 0) {
			throw new IllegalArgumentException("Argumento ilegal");
		}
		return a/b;
	}

}
