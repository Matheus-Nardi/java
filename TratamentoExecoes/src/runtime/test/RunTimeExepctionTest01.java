package runtime.test;

public class RunTimeExepctionTest01 {
public static void main(String[] args) {
	//Checked : Quando não tratadas ja é lançada uma execção.
	//Uncheck : Provalvemente o erro veio do programador e poderiam ser tratadas
	
	//Acessando metodos de um obj nulo
	Object objeto = null;
	System.out.println(objeto.toString());
	
	//Acessando um indice não existente.
	int[] nums = {1,2};
	System.out.println(nums[2]);
	
}
}
