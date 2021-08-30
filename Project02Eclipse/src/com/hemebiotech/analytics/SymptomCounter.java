package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation to count symptoms and return a list of strings sort by alphabetical order
 * with the number of occurrences
 *
 */
public class SymptomCounter implements ISymptomAnalyzer {
	@Override
	public List<String> AnalyzeSymptoms(List<String> rawSymptomList) {

		int headacheCount = 0; // initialize to 0
		int rashCount = 0; // initialize to 0
		int pupilCount = 0; // initialize to 0

		// Count
		for (String line : rawSymptomList) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.equals("dialated pupils")) {
				pupilCount++;
			}
		}

		// Generate output
		List<String> analyzedSymptomList = new ArrayList<String>();
		analyzedSymptomList.add("headache: " + headacheCount);
		analyzedSymptomList.add("rash: " + rashCount);
		analyzedSymptomList.add("dialated pupils: " + pupilCount);
		return analyzedSymptomList;
	}

}
