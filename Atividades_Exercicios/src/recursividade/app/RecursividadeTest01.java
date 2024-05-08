package recursividade.app;

import javax.swing.JOptionPane;

public class RecursividadeTest01 {

	public static void main(String[] args) {
		
		int numero;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero maior que 0"));
		JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é " + fatorial(numero));
	}
	
	
	public static int fatorial(int n) {
		if(n == 0)
			return 1;
		
		return n * fatorial(n-1);
	}

}
