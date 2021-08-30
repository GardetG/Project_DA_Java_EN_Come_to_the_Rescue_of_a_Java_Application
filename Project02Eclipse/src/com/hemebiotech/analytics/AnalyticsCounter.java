package com.hemebiotech.analytics;

public class AnalyticsCounter {
	final static String inputPath = "Project02Eclipse/symptoms.txt";
	final static String outputPath = "Project02Eclipse/result.out";

	public static void main(String args[]) throws Exception {
		// Initialize
		Symptoms mySymptoms = new Symptoms(new ReadSymptomDataFromFile(inputPath), 
				new SymptomCounter(),
				new WriteSymptomDataIntoFile(outputPath));

		// Run
		mySymptoms.Read();
		mySymptoms.Analyze();
		mySymptoms.Write();
	}
}
