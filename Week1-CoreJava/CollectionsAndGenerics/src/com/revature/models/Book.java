package com.revature.models;

public class Book implements Comparable<Book>{
	
	private int id;
	private String author;
	private String title;
	
	public Book() {
		super();
	}

	public Book(int id, String title, String author) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + "]";
	}

	/*
	 * compareTo returns an integer result
	 * if it returns a negative number "this" is considered to be of lesser value 
	 * if it returns a positive number "this" is considered to be of greater value
	 * if it returns 0, the two objects are considered to be of equal value
	 */
	@Override
	public int compareTo(Book otherBook) {
		return this.getAuthor().compareTo(otherBook.getAuthor());
	}


}
