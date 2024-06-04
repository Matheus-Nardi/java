package javacore.ZZHpadroesdeprojeto.dominio;

public class Person {
	//Dessing patter : uma padrão para resolver um problema comum
	//Builder : padronizar a construção e saber quais os argumentos de determinado objeto
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	
	
	private Person(String firstName, String lastName, String username, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
	}
	
	
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", email="
				+ email + "]";
	}



	public static class PersonBuilder{
		private String firstName;
		private String lastName;
		private String username;
		private String email;
		
		public PersonBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public PersonBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public PersonBuilder username(String username) {
			this.username = username;
			return this;
		}
		public PersonBuilder email(String email) {
			this.email= email;
			return this;
		}
		
		public Person build() {
			return new Person(firstName, lastName, username, email);
		}
	}
	
	
}
