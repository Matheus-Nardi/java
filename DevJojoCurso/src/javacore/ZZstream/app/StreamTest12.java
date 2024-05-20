package javacore.ZZstream.app;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.model.Category;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest12 {
	private static List<Book> books = BooksRepository.getBooks();

	public static void main(String[] args) {
		//Grouping by 
		
		Map<Category, List<Book>> collect = books.stream()
			.collect(Collectors.groupingBy(Book::getCategory));
		
		
		for (Map.Entry<Category, List<Book>> entryBook : collect.entrySet()) {
				for (Book books : entryBook.getValue()) {
					System.out.println(entryBook.getKey() + " - " + books.getNome());
				}
		}
		
		collect.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.forEach(entryBook -> {
				Category category = entryBook.getKey();
	            List<Book> booksInCategory = entryBook.getValue();

	            System.out.println("Category: " + category);
	            for (Book book : booksInCategory) {
	                System.out.println(" - " + book.getNome());
	            }
			});
		
		
	}
}
