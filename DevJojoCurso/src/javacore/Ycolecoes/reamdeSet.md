# Conjunto (Set)
Um conjunto, ou Set, é uma estrutura de dados que armazena uma coleção de valores únicos, sem repetições, e não é indexada.

## HashSet, TreeSet e LinkedHashSet
- HashSet: Prioriza a eficiência na busca através de valores hash, não garantindo uma ordem específica durante a iteração.
- TreeSet: Mantém os elementos ordenados de acordo com a ordem natural dos elementos (se forem comparáveis) ou através de um comparador fornecido.
- LinkedHashSet: Mantém a ordem de inserção dos elementos, combinando a eficiência de busca do HashSet com a manutenção da ordem de inserção.

```java
Set<Manga> mangas = new HashSet<>(); 
mangas.add(new Manga("Berserk", 9.55, 0));

TreeSet<String> lista = new TreeSet<>(); // Ordenado

lista.add("Marta");
lista.add("Matheus");
lista.add("Leandra");

Set<Manga> mangasLinked = new LinkedHashSet<>();
mangasLinked.add(new Manga("Berserk", 9.55, 0));
```
