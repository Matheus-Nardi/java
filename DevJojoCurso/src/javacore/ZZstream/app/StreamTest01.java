package javacore.ZZstream.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest01 {
	public static void main(String[] args) {
		List<Book> books = BooksRepository.getBooks();
		
		books.sort((b1,b2) -> b1.getNome().compareToIgnoreCase(b2.getNome()));
		System.out.println(books);
	
		List<String> result = new ArrayList<>();
		Predicate<Book> predicate = book -> book.getPreco() < 25;
		for (Book book2 : books) {
			if(predicate.test(book2))
				result.add(book2.getNome());
			
			if(result.size() >= 3)
				break;
		}
		
		
		System.out.println(result);
	}
	
	
}
