package polimorfismo.models;

public class Abacate extends Produto{
	public static final double IMPOSTO_POR_CENTO= 0.06;
	private String dataValidade;
	public Abacate(String nome, Double valor) {
		super(nome, valor);
	}

	@Override
	public double calcularImposto() {
		System.out.println("Calculando imposto do abacate");
		return getValor() * IMPOSTO_POR_CENTO;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	

}
