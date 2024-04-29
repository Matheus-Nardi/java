package error.test;

public class Main {
	public static void main(String[] args) {
		deadStack();
	}
	
	//Um erro de stack over flow , quando a chamada de métodos e estourada.
	//Um erro que voce não recupera , não é tratavel em tempo de execução
	public static int deadStack() {
		return deadStack();
	}
}
