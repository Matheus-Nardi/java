package polimorfismo.models;

public class Computador extends Produto {

	public static final double IMPOSTO_POR_CENTO= 0.21;
	public Computador(String nome, Double valor) {
		super(nome, valor);
	}

	@Override
	public double calcularImposto() {
		System.out.println("Calculando imposto do computador");
		return getValor() * IMPOSTO_POR_CENTO;
	}

}
