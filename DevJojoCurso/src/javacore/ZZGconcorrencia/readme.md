
### Threads

Threads e concorrência/paralelismo são temas profundos, mas tentarei explicar o que aprendi de forma simplificada.


Uma thread é a menor unidade de execução de um programa. Várias threads podem executar a mesma tarefa simultaneamente, comunicando-se e compartilhando recursos.

Podemos criar uma thread e passar um `Runnable` (uma atividade que a thread realizará) para ela:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class TestRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // Inicia a execução da thread
    }
}
```

### Considerações sobre Threads

Embora threads possam melhorar o desempenho, elas também podem causar problemas, como:

- **Custo de Troca de Contexto**: Alternar entre threads pode ser caro em termos de desempenho.
- **Deadlocks**: Condição em que duas ou mais threads ficam bloqueadas esperando por recursos que nunca serão liberados.

### Concorrência

O acesso simultâneo de múltiplas threads a recursos compartilhados pode causar problemas. Para lidar com isso, utilizamos ferramentas como `synchronized` e `ReentrantLock`.

- **synchronized**: Garante que apenas uma thread por vez execute um bloco de código ou método, bloqueando os demais até que a execução termine.
- **ReentrantLock**: Fornece mais controle sobre o bloqueio, permitindo bloquear e desbloquear explicitamente.

### Programação Assíncrona

A programação assíncrona permite que diferentes partes do programa executem tarefas simultaneamente, sem interromper umas às outras. Isso é útil para operações de longa duração, como consultas a bancos de dados ou chamadas de rede. 

**Future** e **CompletableFuture** são mecanismos usados para manipular resultados futuros de operações assíncronas:

- **Future**: Representa o resultado de uma operação assíncrona que estará disponível no futuro.
- **CompletableFuture**: Extende `Future`, fornecendo uma API mais rica e flexível para compor operações assíncronas.

### Exemplo com `CompletableFuture`

```java
private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
    long start = System.currentTimeMillis();
    CompletableFuture<Double> pricesAsyncFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
    CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
    CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
    CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");

    // Join não precisa tratar exceção
    System.out.println(pricesAsyncFuture1.join());
    System.out.println(pricesAsyncFuture2.join());
    System.out.println(pricesAsyncFuture3.join());
    System.out.println(pricesAsyncFuture4.join());

    long end = System.currentTimeMillis();
    System.out.printf("Tempo passado para busca: %d ms %n", (end - start));
}

public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName) {
    System.out.printf("Obtendo preço de forma assíncrona da loja: %s %n", storeName);
    return CompletableFuture.supplyAsync(this::priceGenerator);
}

private double priceGenerator() {
    System.out.printf("%s gerando preço %n", Thread.currentThread().getName());
    delay();
    return ThreadLocalRandom.current().nextInt(1, 500) * 10;
}
```
