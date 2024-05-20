package javacore.ZZstream.app;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest11 {
	private static List<Book> books = BooksRepository.getBooks();
	public static void main(String[] args) {
		//Sumarização
		
		System.out.println(books.stream().count());
		
		System.out.println(books.stream()
			.collect(Collectors.counting()));
		
		books.stream()
			.collect(Collectors.maxBy(Comparator.comparing(Book::getPreco)))
			.ifPresent(System.out::println);
		
		System.out.println(books.stream()
			.collect(Collectors.summingDouble(Book::getPreco)));
		
		DoubleSummaryStatistics collector = books.stream()
			.collect(Collectors.summarizingDouble(Book::getPreco));
		
		String titles = books.stream()
			.map(Book::getNome)
			.collect(Collectors.joining(",\n"));
		
		System.out.println(titles);
	}
}
