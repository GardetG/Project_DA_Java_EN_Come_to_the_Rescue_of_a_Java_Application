package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will write analyzed symptom data into a target. The data must
 * be provided in the form of an organized list of strings ready to be written
 *
 */
public interface ISymptomWriter {
	/**
	 * 
	 * @param resultList an organized listing of symptom after analysis
	 */
	void PostSymtpoms(List<String> resultList);
}
