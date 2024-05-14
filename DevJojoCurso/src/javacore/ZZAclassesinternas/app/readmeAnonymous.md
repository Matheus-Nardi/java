# Classes/Interfaces Anônimas 
A utilidade de uma classe ou interface anônima é quando se precisa dessa classe ou interface apenas em determinado momento e não se almeja reutilizá-las posteriormente.

Um bom exemplo seria a aplicação de um Comparator:

```java
public static void main(String[] args) {
    List<Carro> carros = new ArrayList<>(
            List.of(new Carro("Ferrari"), new Carro("Mustang"), new Carro("Audi")));
    carros.sort(new Comparator<Carro>() {
        @Override
        public int compare(Carro o1, Carro o2) {
            return o1.getNome().compareToIgnoreCase(o2.getNome());
        }
    });
    System.out.println(carros);      
}
```

No exemplo acima, uma classe anônima é utilizada para implementar a interface Comparator. Isso permite definir a ordem de classificação dos objetos da classe Carro de acordo com o nome,
sem a necessidade de criar uma classe separada para isso.
