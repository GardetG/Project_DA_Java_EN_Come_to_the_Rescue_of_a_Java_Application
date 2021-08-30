package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> rawSymptomList = reader.GetSymptoms();
		
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
		List<String> analyzedSymptomList=new ArrayList<String>();
		analyzedSymptomList.add("headache: " + headacheCount);
		analyzedSymptomList.add("rash: " + rashCount);
		analyzedSymptomList.add("dialated pupils: " + pupilCount);
		
		// Write output
		ISymptomWriter writer = new WriteSymptomDataIntoFile("Project02Eclipse/result.out");
		writer.PostSymtpoms(analyzedSymptomList);
	}
}
