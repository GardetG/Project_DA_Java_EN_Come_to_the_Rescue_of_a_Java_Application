package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will analyze a raw symptom list and return the result in the
 * form of a list of strings
 *
 */
public interface ISymptomAnalyzer {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @param rawSymptomList a raw listing of all Symptoms, duplicates are possible/probable
	 * @return an organized listing of analyzed symptoms
	 */
	List<String> AnalyzeSymptoms(List<String> rawSymptomList);
}
