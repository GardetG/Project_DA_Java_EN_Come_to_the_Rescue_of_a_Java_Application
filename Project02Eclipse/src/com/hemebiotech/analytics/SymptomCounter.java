package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Implements ISymptomAnalyzer to count symptoms and return a list of strings
 * with symptoms and their number of occurrences, sorted alphabetically by
 * default or with a custom comparator
 * 
 * @see ISymptomAnalyzer
 */
public class SymptomCounter implements ISymptomAnalyzer {

	private Comparator<String> orderComparator;

	/**
	 * Default constructor: Set comparator to sort symptoms alphabetically
	 */
	public SymptomCounter() {
		orderComparator = Comparator.naturalOrder();
	}

	/**
	 * Parametric constructor: Set a custom comparator to sort symptoms
	 * 
	 * @param customComparator a comparator to sort symptoms
	 */
	public SymptomCounter(Comparator<String> customComparator) {
		orderComparator = customComparator;
	}

	@Override
	public List<String> AnalyzeSymptoms(List<String> rawSymptomList) {
		// Initialize TreeMap
		SortedMap<String, Integer> symptomMap = new TreeMap<String, Integer>(orderComparator);

		if (rawSymptomList != null) {
			// Counting loop
			for (String line : rawSymptomList) {
				// Ignore the line if it's null, blank or empty
				if (line == null || line.trim().isEmpty()) {
					continue;
				}
				// Prevent duplicate entries in case of letter case variation
				line = line.toLowerCase();
				int numberOfOccurrence = 1;
				// If the symptoms already present in the map, we add the last value to increase
				// it by 1
				if (symptomMap.containsKey(line)) {
					numberOfOccurrence += symptomMap.get(line);
				}
				// Add or update the key
				symptomMap.put(line, numberOfOccurrence);
			}
		}

		// For each pair in the map we add it to the return list using
		// 'symptom: occurrences' format
		List<String> analyzedSymptomList = new ArrayList<String>();
		symptomMap.forEach((symptom, numberOfOccurrence) -> {
			analyzedSymptomList.add(symptom + ": " + numberOfOccurrence);
		});

		return analyzedSymptomList;
	}
}