package javacore.ZZstream.app;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javacore.ZZstream.model.Book;
import javacore.ZZstream.model.Category;
import javacore.ZZstream.repository.BooksRepository;
import javacore.ZZstream.model.Promotion;

public class StreamTest13 {
	private static List<Book> books = BooksRepository.getBooks();

	public static void main(String[] args) {
		// Grouping by preço menor que 25

		Map<Promotion, List<Book>> collect = books.stream().collect(Collectors.groupingBy(b -> 
			 b.getPreco() < 25 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
		));

		for (Map.Entry<Promotion, List<Book>> entry : collect.entrySet()) {
			for (Book bInfo : entry.getValue()) {
				System.out.println(entry.getKey());
				System.out.println(bInfo.getNome() + " - " + bInfo.getPreco());
			}
		}
		
		//GroupBy por promotion e category
		Map<Category, Map<Promotion, List<Book>>> collect2 = books.stream()
			.collect(Collectors.groupingBy(Book::getCategory ,
					Collectors.groupingBy(b -> 
					 b.getPreco() < 25 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
					)));
		
		
		System.out.println(collect2);

	}
}
