package com.hemebiotech.analytics;

import java.util.List;

/**
 * <p>
 * Implemented by classes that will read raw symptom data from a source<br>
 * The return value from the operation is a list of strings that may contain
 * many duplications
 * </p>
 * <p>
 * The implementation does not need to order the list
 * </p>
 * 
 */
public interface ISymptomReader {
	/**
	 * <p>
	 * Read the symptom data<br>
	 * If no data is available, return an empty List
	 * <p>
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> GetSymptoms();
}
