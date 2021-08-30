package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Write into a file
 *
 */
public class WriteSymptomDataIntoFile implements ISymptomWriter {
	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file where analyzed symptom are
	 *                 written, one per line
	 */
	public WriteSymptomDataIntoFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void PostSymtpoms(List<String> resultList) {
		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter(filepath);
				for (String line : resultList) {
					writer.write(line + "\n");
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
