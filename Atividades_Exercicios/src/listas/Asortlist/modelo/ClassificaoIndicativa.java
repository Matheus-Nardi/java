package listas.Asortlist.modelo;

public enum ClassificaoIndicativa {
	LIVRE(1, "Livre"), MAIOR_12(2, "12+"), MAIOR_16(3, "16+"), MAIOR_18(4, "18+");

	private final Integer id;
	private final String label;

	private ClassificaoIndicativa(Integer id, String label) {
		this.id = id;
		this.label = label;

	}

	public Integer getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
	
	public static  void mostrarClassificao() {
		for (ClassificaoIndicativa classificao : values()) {
			System.out.println(classificao.getId() + " - " + classificao.getLabel());
		}
	}
	
	public static ClassificaoIndicativa valueOf(int id) {
		for (ClassificaoIndicativa classificao : values()) {
			if(classificao.getId() == id)
				return classificao;
		}
		
		throw new IllegalArgumentException("Id fora de parametro");
	}
	
	

}
