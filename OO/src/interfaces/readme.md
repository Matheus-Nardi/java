# Interfaces

Uma interface é um exemplo de contrato, onde são declarados métodos que as classes que a implementam devem utilizar.

Isso permite o desacoplamento das classes e possibilita que determinadas classes tenham regras de negócio específicas.

Nas interfaces, é possível declarar métodos sem corpo, ou seja, abstratos, e métodos default, que permitem corpo e não obrigam as classes implementadoras a utilizá-los.

Exemplo: 
```java
public interface DataLoder {
	
	int MAX_DATA_SIZE = 10; // declaracao de atriutos que são static e do tipo final
	void load(); //um metodo abstrato
	
	// default garante um metodo com corpo , não obriga as classes a implementarem
		default void checkPermission() {
			System.out.println("Wait... i'm checking your permission");
			Random rand = new Random();
			int condicao = rand.nextInt(2);
			if(condicao == 1)
				System.out.println("Success!");
			else
				System.out.println("Fail!");
		}
		
		//metodo static , que não é sobreescrito nas classes implementadas
		public static void retriveMaxDataSize() {
			System.out.println("Getting max data size: " + MAX_DATA_SIZE);
			
		}
}

```
