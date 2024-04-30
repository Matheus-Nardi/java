package runtime.test;

public class RuntimeExpectionTest04 {
	public static void main(String[] args) {
		mutipliCatch();
	}

	private static void mutipliCatch() {
		//Sempre do mais especifico para o mais generico
		try {
			throw new ArrayIndexOutOfBoundsException();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Dentro do ArrayIndexOutOfBoundsException");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Dentro de IndexOutOfBoundsException");
		}catch(IllegalArgumentException e) {
			System.out.println("Dentro de IllegalArgumentException");
		}catch(RuntimeException e) {
			System.out.println("Dentro do RuntimeException");
		}
	}
}
