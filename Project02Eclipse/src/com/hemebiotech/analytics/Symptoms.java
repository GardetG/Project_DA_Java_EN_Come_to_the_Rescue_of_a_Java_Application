package com.hemebiotech.analytics;

import java.util.List;

/**
 * This class encapsulate all the logic to read raw symptom data from a source,
 * analyze it, and write the result into a target
 *
 */
public class Symptoms {
	private List<String> rawSymptomList;
	private List<String> analyzedSymptomList;
	private ISymptomReader symptomReader;
	private ISymptomAnalyzer symptomAnalyzer;
	private ISymptomWriter symptomWriter;

	/**
	 * This constructor set the implementation of the read, analyze and write logic
	 * that will be used by this class
	 * 
	 * @see ISymptomReader
	 * @see ISymptomAnalyzer
	 * @see ISymptomWriter
	 * 
	 * @param reader   Class implementing ISymptomReader to get raw data
	 * @param analyzer Class implementing ISymptomAnalyzer to analyze the raw data
	 * @param writer   Class implementing ISymptomWriter to store analyzed data
	 */
	public Symptoms(ISymptomReader reader, ISymptomAnalyzer analyzer, ISymptomWriter writer) {
		symptomReader = reader;
		symptomAnalyzer = analyzer;
		symptomWriter = writer;
	}

	/**
	 * Retrieve the raw symptom data
	 */
	public void Read() {
		rawSymptomList = symptomReader.GetSymptoms();
	}

	/**
	 * Analyze the raw data and store the analyzed data
	 */
	public void Analyze() {
		analyzedSymptomList = symptomAnalyzer.AnalyzeSymptoms(rawSymptomList);
	}

	/**
	 * Write the analyzed symptom data
	 */
	public void Write() {
		symptomWriter.PostSymtpoms(analyzedSymptomList);
	}
}
