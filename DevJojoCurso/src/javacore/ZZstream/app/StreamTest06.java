package javacore.ZZstream.app;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest06 {
	private static List<Book> books = BooksRepository.getBooks();
	public static void main(String[] args) {
		
		boolean bookOver50 = books.stream()
			.anyMatch(b -> b.getPreco() > 50.0);
		
		System.out.println("Há livros com preços maiores que 50 ? "  + (bookOver50 ? "Sim" : "Não"));
		
		
		boolean bookWihoutPrice = books.stream()
			.allMatch(b -> b.getPreco() <= 0);
		
		boolean bookNoneMatch = books.stream()
				.noneMatch(b -> b.getPreco() <= 0);
		
		System.out.println("Há livros com preços incorretos: " + (bookWihoutPrice ? "Sim" : "Não"));
		System.out.println("Há livros com preços incorretos: " + (bookNoneMatch ? "Não" : "Sim"));
		
		 books.stream()
			.filter(b -> b.getPreco() > 60)
			.findAny()
			.ifPresent(System.out::println);
		 
		 books.stream()
			.filter(b -> b.getPreco() < 40)
			.sorted(Comparator.comparing(Book::getPreco))
			.findFirst()
			.ifPresent(System.out::println);
		
	}
}
