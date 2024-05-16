package javacore.ZZstream.app;

import java.util.List;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest03 {
	private static List<Book> books = BooksRepository.getBooks();

	public static void main(String[] args) {
		
		books.stream()
		.forEach(System.out::println);
		
		Long count = books.stream()
		.filter(b -> b.getPreco() <=25)
		.count();
		
		System.out.println("Livros com preço menor ou igual a 25: " + count);
	
	}
}
