package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Implementation to count symptoms and return a list of strings with the number
 * of occurrences sort by alphabetical order by default or with a custom
 * comparator.
 *
 */
public class SymptomCounter implements ISymptomAnalyzer {

	private Comparator<String> orderComparator;

	public SymptomCounter() {
		orderComparator = Comparator.naturalOrder();
	}

	/**
	 * 
	 * @param customComparator a custom Comparator<String> to sort the symptom list
	 */
	public SymptomCounter(Comparator<String> customComparator) {
		orderComparator = customComparator;
	}

	@Override
	public List<String> AnalyzeSymptoms(List<String> rawSymptomList) {
		// Initialize TreeMap
		SortedMap<String, Integer> symptomMap = new TreeMap<String, Integer>(orderComparator);

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

		// For each pair in the map we add it to the return list using
		// 'symptom: occurrences' format
		List<String> analyzedSymptomList = new ArrayList<String>();
		symptomMap.forEach((symptom, numberOfOccurrence) -> {
			analyzedSymptomList.add(symptom + ": " + numberOfOccurrence);
		});
		return analyzedSymptomList;
	}

}
