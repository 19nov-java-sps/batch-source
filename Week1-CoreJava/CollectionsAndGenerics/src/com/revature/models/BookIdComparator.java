package com.revature.models;

import java.util.Comparator;

public class BookIdComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		return book1.getId() - book2.getId();
	}

}
