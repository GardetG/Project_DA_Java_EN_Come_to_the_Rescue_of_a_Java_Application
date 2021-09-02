package com.hemebiotech.analytics;

import java.util.List;

/**
 * <p>
 * Implemented by classes that will analyze a raw symptom list and return the
 * result in the form of a list of strings<br>
 * The returned list must be sorted and organized without any duplicates
 * </p>
 * 
 */
public interface ISymptomAnalyzer {
	/**
	 * <p>
	 * Analyze the symptoms<br>
	 * If no data is available, return an empty List
	 * </p>
	 * 
	 * @param rawSymptomList a raw listing of all Symptoms, duplicates are
	 *                       possible/probable
	 * @return an organized listing of analyzed symptoms
	 */
	List<String> AnalyzeSymptoms(List<String> rawSymptomList);
}
