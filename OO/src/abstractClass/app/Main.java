package abstractClass.app;

import abstractClass.Desenvolvedor;
import abstractClass.Gerente;

public class Main {

	public static void main(String[] args) {
		 Gerente g = new Gerente("Kuri" , 4500.0);
		 System.out.println(g.getSalario());
		 
		 Desenvolvedor dev = new Desenvolvedor("Tanaka" , 3100.0);
		 System.out.println(dev.getSalario());

	}

}
