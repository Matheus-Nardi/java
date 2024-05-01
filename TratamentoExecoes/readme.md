# Tratamento de Exceções (try-catch)
Antes de abordarmos o tratamento de exceções, é essencial compreender dois conceitos-chave:

Exceções do tipo unchecked: São "erros" que não exigem tratamento obrigatório e geralmente resultam de falhas na lógica de programação, podendo ser chamadas de RuntimeException e estendendo de Exception.
Exceções do tipo checked: São "erros" que requerem tratamento obrigatório ou o lançamento de uma exceção em sua assinatura. Podem ser chamadas de Exception.
O tratamento de exceções é essencial quando precisamos executar um código suscetível a erros que podem interromper o fluxo do programa de maneira abrupta.

```java
try {
    // Código suscetível a exceções
    // ...
} catch (IllegalArgumentException exception) {
    // Tratamento para exceções do tipo IllegalArgumentException
    // ...
} catch (RuntimeException exception) {
    // Tratamento para exceções do tipo RuntimeException
    // ...
} finally {
    // Bloco finally (opcional) para execução de código que deve ser executado
    // independentemente de ocorrer uma exceção ou não
    // ...
}

```
O bloco finally é útil para executar código que deve ser processado independentemente de ocorrer uma exceção ou não. Por exemplo, é comum usar o bloco finally para fechar conexões com bancos de dados.

Uma boa prática é capturar exceções mais específicas antes das mais genéricas, para garantir um tratamento adequado dos diferentes tipos de erro.

Além disso, o lançamento de exceções, seja dentro de um método ou em sua assinatura, permite que quem chama o método saiba que tipo de exceção esperar e como lidar com ela.

```java
private static int divisao(int a, int b) throws IllegalArgumentException {
    if(b == 0) {
        throw new IllegalArgumentException("Argumento ilegal"); // Lançando uma exceção
    }
    return a / b;
}
```
Quando uma exceção é declarada na assinatura de um método, quem o chama é obrigado a considerar o tratamento adequado para essa exceção.
