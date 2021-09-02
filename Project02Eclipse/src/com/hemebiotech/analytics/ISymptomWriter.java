package com.hemebiotech.analytics;

import java.util.List;

/**
 * <p>
 * Implemented by classes that will write analyzed symptom data into a
 * target<br>
 * The data must be provided in the form of a sorted and organized list of
 * strings without any duplicates
 * </p>
 *
 */
public interface ISymptomWriter {
	/**
	 * <p>
	 * Write analyzed symptom data
	 * </p>
	 * 
	 * @param resultList an organized listing of symptom after analysis
	 */
	void PostSymtpoms(List<String> resultList);
}
