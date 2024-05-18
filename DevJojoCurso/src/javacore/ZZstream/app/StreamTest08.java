package javacore.ZZstream.app;

import java.util.List;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest08 {
	private static List<Book> books = BooksRepository.getBooks();

	public static void main(String[] args) {
		
		//Retornar a soma dos valores dos livros que possuem preco <25
		System.out.println(books.stream()
			.filter(b -> b.getPreco() < 25)
			.mapToDouble(Book::getPreco)
			.sum());
		
		System.out.println(books.stream()
			.mapToDouble(Book::getPreco)
			.filter(x -> x < 25)
			.reduce(0, Double::sum));
	}
}
