package javacore.ZZAclassesinternas.app;

public class OuterClassesTest02 {
	private String name = "Napoleão";
	
	//Local class
	void print() {
		final int idade = 23;
		class LocalClass{
			public void printLocal() {
				System.out.println(OuterClassesTest02.this.name + " - " + idade);
				System.out.println("Isso parece gambiarra");
			}
		}
		LocalClass local = new LocalClass();
		local.printLocal();
	}
	
	public static void main(String[] args) {
		OuterClassesTest02 outer = new OuterClassesTest02();
		outer.print();
	}
}
