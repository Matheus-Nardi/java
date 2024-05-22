
# Stream
O Stream representa uma forma de trabalhar com fluxo de dados, ou seja, processar dados um após o outro. O Stream possui uma sintaxe declarativa e se integra bem com outros elementos do Java, como lambdas e method references (quando sua expressão lambda faz chamada a um único método).

Os Streams podem ser intermediários, ou seja, geram outros Streams que podem ser processados novamente. E podem ser do tipo terminal, dando fim ao Stream/gerando um efeito colateral.

## Exemplos de operações 
Vamos supor que, dada uma coleção de livros, queremos obter de forma ordenada os 3 primeiros que possuem um valor maior que 25.

```java
List<String> livros = books.stream()
    .sorted(Comparator.comparing(Book::getNome)) // Ordenando os livros usando method references
    .filter(b -> b.getPreco() > 25) // Filtrando pelo preço
    .limit(3) // Definindo um limite
    .map(Book::getNome) // Transformando o Stream de livros em um Stream de nomes
    .collect(Collectors.toList()); // Transformando os dados em uma nova lista

System.out.println(livros);
```

### Coletores/Collectors
Os Collectors são uma interface que permite a agregação/junção de dados.

```java
Map<Category, List<Book>> collect = books.stream()
    .collect(Collectors.groupingBy(Book::getCategory)); // Agrupando os livros por sua categoria

DoubleSummaryStatistics collector = books.stream()
    .collect(Collectors.summarizingDouble(Book::getPreco)); // Gerando estatísticas sobre os valores dos livros (quantidade, soma, média, máximo, mínimo)

System.out.println(collector);
```

## Nota
Os Streams são mais amplos que os exemplos fornecidos acima. Para mais informações, consulte a [documentação](https://www.oracle.com/br/technical-resources/articles/java/processing-streams-java-se-8.html).

---
