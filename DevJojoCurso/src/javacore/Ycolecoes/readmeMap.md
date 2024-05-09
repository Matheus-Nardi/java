# Mapa
Um Mapa é uma das coleções compostas por uma chave e um valor. As chaves não podem ser duplicadas.

Dado que um Mapa é uma interface, podemos utilizar HashMap (é importante ter o método hashCode e equals sobrescritos) e LinkedHashMap (que mantém a ordem de inserção).

## Métodos
Podemos adicionar elementos utilizando o método put, retornar o tamanho com size e obter um valor específico passando uma chave.

```java
Map<Integer, String> mapa = new HashMap<>();
mapa.put(1, "TO");
mapa.put(2, "SC");
mapa.put(3, "CE");
mapa.put(4, "AM");

System.out.println(mapa.size());
System.out.println(mapa.get(3));
System.out.println(mapa.size());
```

## Percorrendo um mapa
Podemos percorrer um mapa pela sua chave, pelo seu valor ou ambos.

```java
for(Integer chave : mapa.keySet()) {
    System.out.println("Chave: " + chave + " - Valor: " + mapa.get(chave));
}
System.out.println("--------------------");

for (String valor : mapa.values()) {
    System.out.println("Valor: " + valor);
}
System.out.println("--------------------");

for (Map.Entry<Integer, String> parChaveValor : mapa.entrySet()) {
    System.out.println("Chave: " + parChaveValor.getKey() + " - Valor: " + parChaveValor.getValue());
}
```

## Uma lista de mapas e uma lista como valor
Há a possibilidade de termos uma lista de mapas ou mesmo passar uma lista como valor.

```java
List<Map<Integer,String>> listaDeMapas = new ArrayList<>(); // Lista de mapas
Map<Consumidor, List<Manga>> mapaDeListas = new HashMap<Consumidor, List<Manga>>();   // Mapa com lista
```

## NavigableMap e TreeMap
O diferencial dessa interface é a ordenação dos elementos. Portanto, a chave passada deve ter um comparável implementado ou na declaração do TreeMap deve-se incluir um comparador como parâmetro.
