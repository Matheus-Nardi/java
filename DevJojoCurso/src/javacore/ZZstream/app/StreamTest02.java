package javacore.ZZstream.app;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest02 {
	private static List<Book> books = BooksRepository.getBooks();
	public static void main(String[] args) {
		//Intermediara , retorna o proprio stream
	
			List<String> livros = books.stream()
			.sorted(Comparator.comparing(Book::getNome))
			.filter(b -> b.getPreco() <=25)
			.limit(3)
			.map(Book::getNome)
			.collect(Collectors.toList());
			
			System.out.println(livros);
	}
	
}

	
