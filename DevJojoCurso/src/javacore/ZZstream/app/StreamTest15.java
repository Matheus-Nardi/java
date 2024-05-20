package javacore.ZZstream.app;

import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.model.Category;
import javacore.ZZstream.model.Promotion;
import javacore.ZZstream.repository.BooksRepository;

public class StreamTest15 {
	private static List<Book> books = BooksRepository.getBooks();
	public static void main(String[] args) {
		
		//Estasticias por categoria
		
		Map<Category, DoubleSummaryStatistics> collect = books.stream()
			.collect(Collectors.groupingBy(Book::getCategory, Collectors.summarizingDouble(Book::getPreco)));
		
		collect.entrySet().stream()
			.forEach(System.out::println);
		
		Map<Category, Set<Promotion>> collect2 = books.stream()
			.collect
			(Collectors.groupingBy(Book::getCategory,
					Collectors.mapping(StreamTest15::getPromotion, 
							Collectors.toSet())));
		
		System.out.println(collect2);
		
		
		Map<Category, Set<Promotion>> collect3 = books.stream()
				.collect
				(Collectors.groupingBy(Book::getCategory,
						Collectors.mapping(StreamTest15::getPromotion, 
								Collectors.toCollection(LinkedHashSet::new))));
		
		System.out.println(collect3);
			
		
		
	}
	
	public static Promotion getPromotion(Book b) {
		return b.getPreco() < 25 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
	}
}
