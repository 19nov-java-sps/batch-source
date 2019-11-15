package com.revature.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.models.Book;
import com.revature.models.BookIdComparator;

public class ListDemo {
	
	public static void main(String[] args) {
		/*
		 * using the Arrays utility class to convert an array of books
		 * to a list of books
		 */
		List<Book> bookList = Arrays.asList(new Book[]{
			new Book(35, "Split Infinity", "Piers Anthony"),
			new Book(76, "20th Century Boys", "Naoki Urasawa"),
			new Book(4, "Brave New World", "Aldous Huxley")
		});
		
		System.out.println(bookList);
		System.out.println();
		
		Collections.sort(bookList);
		
		System.out.println(bookList);
		System.out.println();
		
		Comparator<Book> idCompare = new BookIdComparator();
		
		Collections.sort(bookList, idCompare);
		System.out.println(bookList);
		
	}
	
}
