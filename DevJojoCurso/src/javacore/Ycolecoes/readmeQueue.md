# Fila
A fila é uma estrutura de dados que implementa a lógica FIFO - First In, First Out. Ou seja, o primeiro elemento a entrar é o primeiro a sair.

## Métodos
A fila possui métodos para diversas situações, podendo ou não lançar exceções.

```java
Queue<String> fila = new LinkedList<>();

fila.add("Ana"); // Retorna true ou false quando a fila está cheia
fila.offer("Bia"); // Lança uma exceção quando a fila está cheia

System.out.println(fila.peek()); // Recupera o elemento. Quando a lista está vazia, retorna nulo
System.out.println(fila.element()); // Recupera o elemento. Retorna uma exceção

System.out.println(fila.poll()); // Recupera e remove o elemento. Retorna null se estiver vazia
System.out.println(fila.poll()); // Recupera e remove o elemento. Lança uma exceção se estiver vazia
```

## PriorityQueue
A diferença desta implementação está na ordenação dos elementos, a partir de um Comparable ou Comparator, ignorando a ordem de inserção.

```java
class ConsumidorById implements Comparator<Consumidor> {

    @Override
    public int compare(Consumidor o1, Consumidor o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

Queue<Consumidor> fila = new PriorityQueue<Consumidor>(new ConsumidorById());
fila.add(new Consumidor("Marcelinho"));
```
