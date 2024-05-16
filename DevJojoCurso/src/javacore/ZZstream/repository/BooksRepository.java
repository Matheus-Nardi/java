package javacore.ZZstream.repository;

import java.util.ArrayList;
import java.util.List;

import javacore.ZZstream.model.Book;

public class BooksRepository {
	private static List<Book> books = new ArrayList<Book>(List.of(new Book(1, "O pequeno principe", 24.99) ,
			new Book(2, "A revolução dos bichos", 15.99),
			new Book(3, "Home Sapiens", 61.99),
			new Book(4, "Porque nos dormimos ?", 45.99) ,
			new Book(5, "Meu pé de laranja lima", 20.99),
			new Book(6, "Código limpo", 22.30)));
	
	public static List<Book> getBooks() {
		return books;
	}
}
