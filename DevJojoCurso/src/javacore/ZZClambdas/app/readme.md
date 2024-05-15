# Lambdas
As expressões lambda são formas de utilizar interfaces de maneira anônima, desde que essa interface seja funcional, ou seja, possua apenas um método abstrato.

Por meio das lambdas, temos um código conciso e reduzido. De maneira geral, é expressa por um parâmetro, uma arrow function (`->`) e uma expressão.

```java
listaQualquer.forEach(n -> System.out.println(n));
```

## Consumer 
Essa interface possui a seguinte assinatura:
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
Ou seja, ela recebe um parâmetro e é utilizada quando trabalhamos com retornos do tipo void, como um `System.out.println`. O exemplo do `forEach` acima é a utilização de um consumer.

## Predicate
Essa interface possui a seguinte assinatura:
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
Uma interface que, dado determinado parâmetro, retorna true ou false. Comumente utilizada para filtrar coisas. Exemplo: Desejo filtrar strings de tamanho 4 ou superior.
```java
public static List<String> moreOrEquals4Length(List<String> nomes , Predicate<String> predicate){
    List<String> filter = new ArrayList<String>();
    for (String e : nomes) {
        if(predicate.test(e)) {
            filter.add(e);
        }
    }
    
    return filter;
}

public static void main(String[] args) {
    List<String> nomes = List.of("Java","c#","php","javaScript","rust","cobol");
    List<String> newList = moreOrEquals4Length(nomes, n -> n.length() >= 4);
}
```

## Function 
Essa interface possui a seguinte assinatura:
```java
public interface Function<T, R> {
    R apply(T t);
}
```
Essa interface retorna um tipo quando é passado outro tipo. Por exemplo, desejo passar uma lista de números e retornar apenas os quadrados desses números (4 -> 16). De maneira grosseira, ela faz uma transformação.

```java
public static void main(String[] args) {
    List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
    System.out.println(square(nums , n -> n * n));
}

private static List<Integer> square(List<Integer> list , Function<Integer,Integer> function){
    List<Integer> result = new ArrayList<Integer>();
    for (Integer integer : list) {
        Integer n = function.apply(integer);
        result.add(n);
    }
    
    return result;
}
```
