package javacore.ZZstream.app;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.model.Category;
import javacore.ZZstream.repository.BooksRepository;
import javacore.ZZstream.model.Promotion;

public class StreamTest14 {
	private static List<Book> books = BooksRepository.getBooks();

	public static void main(String[] args) {
		//Count de livro por quantidade
		
		Map<Category, Long> collect = books.stream()
			.collect(Collectors.groupingBy(Book::getCategory , Collectors.counting()));
	
		System.out.println(collect);
		
		//Categoria e maior preco
		Map<Category, Optional<Book>> collect2 = books.stream()
			.collect
			(Collectors.groupingBy(Book::getCategory ,
			 Collectors.maxBy(Comparator.comparing(Book::getPreco)))
			);
		
		System.out.println(collect2);
	}
}
