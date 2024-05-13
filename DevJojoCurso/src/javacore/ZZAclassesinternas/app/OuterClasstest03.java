package javacore.ZZAclassesinternas.app;

public class OuterClasstest03 {
	private String name;
	private static Integer idade;
	
	public OuterClasstest03() {
		name = "Junk Cook";
		idade = 23;
	}
	static class Nested{
		void print() {
			System.out.println(new OuterClasstest03().name);
			System.out.println(idade);
		}
	}
	public static void main(String[] args) {
		//As classes aninhadas static são como classes que estão fora da outra 
		//mas visualmente e no codigo está dentro da outra
		//A classe interna é depedente da externa;
		Nested nested = new Nested();
		nested.print();

	}

}
