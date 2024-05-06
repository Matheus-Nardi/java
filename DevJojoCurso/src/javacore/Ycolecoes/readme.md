# Listas em Java

As listas em Java são estruturas de dados dinâmicas que podem aumentar e diminuir de tamanho de forma flexível, semelhante aos arrays.

## Interfaces e Implementações

Java fornece a interface `List`, que é implementada por várias classes, incluindo `ArrayList` e `LinkedList`. A escolha entre essas implementações depende dos requisitos específicos do seu aplicativo.

Alguns métodos comuns em listas incluem `size()`, `add()`, `remove()` e `get()`.

## Ordenação de Listas

Você pode ordenar listas em Java usando os métodos `sort()` e fornecendo uma implementação de `Comparable` ou `Comparator`.

### Implementando Comparable

```java
public class Filme implements Comparable<Filme> {
    private String titulo;
    private Duration duracao;

    @Override
    public int compareTo(Filme filme) {
        return this.getTitulo().compareToIgnoreCase(filme.getTitulo()); // Comparando por título
    }
}
```

### Implementando Comparator

```java
public class FilmeByDuration implements Comparator<Filme> {
    @Override
    public int compare(Filme o1, Filme o2) {
        return o1.getDuracao().compareTo(o2.getDuracao());
    }
}
```

### Aplicando Ordenação

```java
public static void mostrarFilmes() {
    Collections.sort(filmes);
    for (int i = 0; i < filmes.size(); i++) {
        System.out.println(i + " - " + filmes.get(i));
    }
}

public static void mostrarFilmesByDuration() {
    filmes.sort(new FilmeByDuration());
    for (int i = 0; i < filmes.size(); i++) {
        System.out.println(i + " - " + filmes.get(i));
    }
}
```

## Observações Adicionais

Os métodos `compare()` e `compareTo()` retornam um valor inteiro, seguindo a lógica:

- Retorna um valor negativo se o objeto atual for menor que o objeto passado como parâmetro.
- Retorna zero se o objeto atual for igual ao objeto passado como parâmetro.
- Retorna um valor positivo se o objeto atual for maior que o objeto passado como parâmetro.
```
