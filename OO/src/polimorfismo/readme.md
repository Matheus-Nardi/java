# Polimorfismo

O polimorfismo é responsável pelas "múltiplas formas" que as classes podem ser declaradas.

Exemplo: uma classe abstrata chamada Produto que se estende para produtos específicos. É possível realizar as seguintes declarações:

```java
public class Main {

	public static void main(String[] args) {
		Produto p = new Computador("ACERi5 ASPIRE", 3550.00); // isso é polimorfismo, múltiplas formas
		Produto p2 = new Abacate("Abacate Grego", 12.99);
	}
```

Um computador é um produto.

Um abacate é um produto.

Exemplo de um método que recebe um parâmetro polimórfico, exemplo de um cast de uma superclasse para uma subclasse e aplicação do operador `instanceof`:

```java
public class CalculadoraImposto {
	public static void calcularImpostoProduto(Produto produto) {
		System.out.println("Relatório de taxação");
		System.out.println("Produto: " + produto.getNome() + " - " +  produto.getValor());
		System.out.println("Valor imposto: " + produto.calcularImposto());
		if(produto instanceof Abacate)
			((Abacate)produto).getDataValidade();
	}
}
```
