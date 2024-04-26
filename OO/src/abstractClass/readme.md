
# Classes Abstratas

Uma classe abstrata está intimamente ligada ao contexto de herança e é utilizada, por exemplo, quando uma classe serve apenas como um modelo ou template para outras. A razão de sua existência é para ser estendida.

Imagine o contexto de uma classe Veículo que possui duas subclasses: Carro e Moto. Não faz sentido instanciar um Veículo, mas sim um Carro ou uma Moto.

Também há a possibilidade de métodos abstratos, os quais só podem estar em classes abstratas e não possuem corpo. As classes que estendem a classe abstrata são obrigadas a implementar o método abstrato e definir sua própria regra.

Existem também os métodos abstratos com a palavra reservada `default`, os quais serão explicados em Interfaces.

Exemplo de uma classe abstrata:
```
public abstract class Funcionario {

	private String nome;
	private Double salario;

	public Funcionario(String nome, Double salario) {
		super();
		this.nome = nome;
		this.salario = salario;
		calcularBonus();
	}

//Garante que para toda classe extendida haja esse método
	public abstract void calcularBonus();
```
