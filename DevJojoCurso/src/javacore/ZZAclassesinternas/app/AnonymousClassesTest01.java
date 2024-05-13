package javacore.ZZAclassesinternas.app;

class Animal{
	void walk() {
		System.out.println("The animal is walking");
	}
}
public class AnonymousClassesTest01 {
	public static void main(String[] args) {
		//Classes anonimas  que existiram por tempo limitado e não pode ser reutilizada
		Animal animal = new Animal() {
			@Override
			void walk() {
				System.out.println("Now,the animal is walking slowly");
			}
		};
		animal.walk();
	}

}
