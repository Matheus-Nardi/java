# Generics
Os generics surgem como uma forma de estabilizar o código, evitando erros que ocorreriam em tempo de execução, como, por exemplo, o type erasure. Mas também para a criação de classes e tipos genéricos que serão modelados de acordo com a necessidade.

## Wildcard
Os wildcards, são as cartas coringas que cumprem a função dos generics em fornecer um tempo de execução seguro. São representados pelo símbolo '?'.

```java
private static void showConsulta(List<? extends Animal> animais) {
    for (Animal animal : animais) {
        animal.consulta();
    }
    
    // Não posso adicionar elementos, apenas realizar a leitura
    // Não há uma certeza se é um Cachorro ou Gato
}
```
Nesse primeiro exemplo, é usado um wildcard para qualquer coisa que estenda da classe Animal, neste nosso contexto, um gato ou cachorro.

```java
private static void showConsultaAnimal(List<? super Animal> animais) {
    for (Object animal : animais) {
        ((Animal) animal).consulta();
    }
    
    animais.add(new Gato());
    
    // Posso adicionar devido ao polimorfismo, o pai de animal é Object 
    // Tanto faz ser um gato ou cachorro, é um Object!
}
```
Neste exemplo, é usado um wildcard que abrange qualquer coisa que esteja acima da classe Animal, ou seja, um Object.
