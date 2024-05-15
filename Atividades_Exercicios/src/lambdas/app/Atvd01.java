package lambdas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Atvd01 {

	public static void main(String[] args) {
		List<String> cores = List.of("Amarelo","Roxo","Verde","Azul","Branco");
		upper(cores, cor -> System.out.println(cor.toUpperCase()));
	}
	private static void upper(List<String> cores, Consumer<String> consumer) {
		for (String string : cores) {
			consumer.accept(string);
		}
	}

}
