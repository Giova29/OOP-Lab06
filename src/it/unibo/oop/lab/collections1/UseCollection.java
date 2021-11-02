package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int ELEMS_TO_ADD = 100_000;
	private static final int ELEMS_TO_READ = 1_000;
	private static final int TO_MS = 1_000_000;
	
    private UseCollection() {
    }

    private static void fillMap(Map<String, Long> map) {
    	map.put("Africa", 1_110_635_000L);
    	map.put("Americas", 972_005_000L);
    	map.put("Antartica", 0L);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", 742_452_000L);
    	map.put("Oceania", 38_304_000L);
    }
    
    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	List<Integer> arrayList = new ArrayList<>();
    	
    	for (int i = 1000; i < 2000; i++) {
    		arrayList.add(i);
    	}
    	
    	List<Integer> linkedList = new LinkedList<>(arrayList);
    	final int first = arrayList.get(0);
    	arrayList.set(0, arrayList.get(arrayList.size() - 1));
    	arrayList.set(arrayList.size() - 1, first);
    	
    	for (final int e: arrayList) {
    		System.out.print(e + " ");
    	}
    	System.out.println();
    	
    	arrayList = new ArrayList<>();
    	long time = System.nanoTime();
    	for (int i = 1; i <= ELEMS_TO_ADD; i++) {
    		arrayList.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Time to add " + ELEMS_TO_ADD + " in the head of the ArrayList:\t\t\t" + time + "ns,\t" + time / TO_MS + "ms");
    	
    	linkedList = new LinkedList<>();
    	time = System.nanoTime();
    	for (int i = 1; i <= ELEMS_TO_ADD; i++) {
    		linkedList.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Time to add " + ELEMS_TO_ADD + " in the head of the LinkedList:\t\t\t" + time + "ns,\t" + time / TO_MS + "ms");
    	
    	time = System.nanoTime();
    	for(int i = 1; i <= ELEMS_TO_READ; i++) {
    		arrayList.get(ELEMS_TO_ADD / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Time to read " + ELEMS_TO_READ + " elements from the middle of the ArrayList:\t\t" + time + "ns,\t" + time / TO_MS + "ms");
    	
    	time = System.nanoTime();
    	for(int i = 1; i <= ELEMS_TO_READ; i++) {
    		linkedList.get(ELEMS_TO_ADD / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Time to read " + ELEMS_TO_READ + " elements from the middle of the LinkedList:\t\t" + time + "ns,\t" + time / TO_MS + "ms");
    	
    	final Map<String, Long> map = new HashMap<>();
    	fillMap(map);
    	long worldPopulation = 0;
    	for (Entry<String, Long> e: map.entrySet()) {
    		worldPopulation += e.getValue();
    	}
    	System.out.println("World population = " + worldPopulation);
    }
}
