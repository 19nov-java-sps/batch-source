package com.revature.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.revature.models.Book;
import com.revature.models.BookIdComparator;

public class SetDemo {

	public static void main(String[] args) {
		
		/*
		 * HashSet
		 * - no repeating values
		 * - not sorted or ordered
		 * - order can change over time
		 * - relies on the hashcode method
		 * - contains HashMap, using a dummy value
		 * 
		 */
		
		HashSet<Integer> hSet1 = new HashSet<>();
		hSet1.add(5);
		hSet1.add(9);
		hSet1.add(2);
		hSet1.add(1);
		hSet1.add(8);
		hSet1.add(13);
		hSet1.add(8);
		hSet1.add(17);
		hSet1.add(82);
		hSet1.add(139);
		System.out.println(hSet1);
		
		/*
		 * LinkedHashSet
		 * - hashset with a linked list running through the elements
		 * - less efficient than HashSet because the LinkedList must be maintained
		 * - maintains insertion order
		 */
		
		LinkedHashSet<Integer> lhSet1 = new LinkedHashSet<>();
		lhSet1.add(5);
		lhSet1.add(9);
		lhSet1.add(2);
		lhSet1.add(1);
		lhSet1.add(8);
		lhSet1.add(13);
		lhSet1.add(8);
		lhSet1.add(17);
		lhSet1.add(82);
		lhSet1.add(139);
		System.out.println(lhSet1);
		
		
		/*
		 * TreeSet 
		 * - sorted using natural ordering (or that provided by a comparator)
		 * - uses a binary search tree to maintain order
		 */
		
		TreeSet<Integer> tSet1 = new TreeSet<>();
		tSet1.add(5);
		tSet1.add(9);
		tSet1.add(2);
		tSet1.add(1);
		tSet1.add(8);
		tSet1.add(13);
		tSet1.add(8);
		tSet1.add(17);
		tSet1.add(82);
		tSet1.add(139);
		System.out.println(tSet1);
		
		
		TreeSet<String> tSet2 = new TreeSet<>();
		tSet2.add("alpha");
		tSet2.add("bravo");
		tSet2.add("charlie");
		tSet2.add("delta");
		tSet2.add("echo");
		System.out.println(tSet2);
		
		
		/*
		 * we discover here that if we start adding 
		 * a particular type, that type will be used 
		 * and additional elements will be cast to that 
		 * element's type
		 */
//		TreeSet tSet3 = new TreeSet();
//		tSet3.add("alpha");
//		tSet3.add("bravo");
//		tSet3.add("charlie");
//		tSet3.add("delta");
//		tSet3.add(5);
//		System.out.println(tSet3);
		
		
		/*
		 * We see these are not in any particular order 
		 * and adding more subjects the order to change
		 */
		HashSet<String> hSet2 = new HashSet<>();
		hSet2.add("alpha");
		hSet2.add("bravo");
		hSet2.add("charlie");
		hSet2.add("delta");
		hSet2.add("echo");
		System.out.println(hSet2);
		
		
		/*
		 * We used a comparator here which allowed us
		 * to include an independent means of comparison.
		 * Without a comparator provided as a parameter 
		 * to the TreeSet, the ordering is determined by
		 * the implementation of the Comparable interface.
		 * 
		 */
		Comparator<Book> idCompare = new BookIdComparator();
		TreeSet<Book> tSet4 = new TreeSet<>(idCompare);
		tSet4.add(new Book(35, "Split Infinity", "Piers Anthony"));
		tSet4.add(new Book(76, "20th Century Boys", "Naoki Urasawa"));
		tSet4.add(new Book(4, "Brave New World", "Aldous Huxley"));
		tSet4.add(new Book(12, "Island", "Aldous Huxley"));
		
		// we can use a dynamic for loop or a "for each" loop to iterate
		for(Book b: tSet4) {
			System.out.println(b);
		}
		
		// we can also use the iterator
		Iterator<Book> i = tSet4.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		
		
	}
	
}
