package runtime.test;

public class RuntimeExpectionTest02 {

	public static void main(String[] args) {
		System.out.println(divisao(1,0));
	}
	
	//Sempre tentar buscas as mais especificas
	//Posso também na assinatura do método já avisar que pode lançar uma execção
	
	/**
	 * 
	 * @param a
	 * @param b não pode ser zero
	 * @return
	 * @throws IllegalArgumentException quando b é zero
	 */
	private static int divisao(int a, int b) throws IllegalArgumentException {
		if(b == 0) {
			throw new IllegalArgumentException("Argumento ilegal"); //Lancando uma execao
		}
		return a/b;
	}

}
