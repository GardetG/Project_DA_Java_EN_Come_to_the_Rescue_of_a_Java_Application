package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Implements ISymptomWriter to write analyzed symptom data into a file
 * 
 * @see ISymptomWriter
 */
public class WriteSymptomDataIntoFile implements ISymptomWriter {
	private String filepath;

	/**
	 * Set the path to target file where analyzed symptom are written, one per line
	 * 
	 * @param filepath a full or partial path to file
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
					// Add a new line if current one isn't the first line in the list
					if (line != resultList.get(0)) {
						writer.write("\n");
					}
					writer.write(line);

				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
