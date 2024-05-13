package javacore.ZZAclassesinternas.app;

public class OuterClassesTest01 {
	private String name = "Pietro Jeskbe";
	
	//Class Interna / Nested Class
	private class Inner{
		public void printOuterClassAtribute() {
			System.out.println(name);
			System.out.println(OuterClassesTest01.this.name);
		}
		
	}
	public static void main(String[] args) {
		//Classe interna : util quando o aclopamento entre classes é muito grande
		Inner inner = new OuterClassesTest01().new Inner();
		inner.printOuterClassAtribute();
	}
	
	
}
