package com.hemebiotech.analytics;

import java.util.List;

/**
 * Class analyzing the raw symptom data from a source and writing the result
 * into a target
 *
 */
public class Symptoms {
	private List<String> rawSymptomList;
	private List<String> analyzedSymptomList;
	private ISymptomReader symptomReader;
	private ISymptomAnalyzer symptomAnalyzer;
	private ISymptomWriter symptomWriter;

	/**
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

	public void Read() {
		rawSymptomList = symptomReader.GetSymptoms();
	}

	public void Analyze() {
		analyzedSymptomList = symptomAnalyzer.AnalyzeSymptoms(rawSymptomList);
	}

	public void Write() {
		symptomWriter.PostSymtpoms(analyzedSymptomList);
	}
}
