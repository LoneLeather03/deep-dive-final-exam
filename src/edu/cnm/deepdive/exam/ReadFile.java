package edu.cnm.deepdive.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/* Class that reads input file **/
public class ReadFile {

	public Float[][] valueList;

	/* Method for reading input file **/
	public ReadFile(String file) {

		try (FileReader reader = new FileReader(file); BufferedReader buffer = new BufferedReader(reader);) {
			LinkedList<Float[]> work = new LinkedList<>();
			String line;
			while ((line = buffer.readLine()) != null) {
				if (line.trim().length() > 0) {
					String[] values = line.trim().split("\\s+");
					Float[] FloatValues = new Float[values.length];
					for (int i = 0; i < values.length; i++) {
						FloatValues[i] = Float.parseFloat(values[i]);
					}
					work.add(FloatValues);
				}
			}
			valueList = work.toArray(new Float[0][]);

		} catch (NumberFormatException ex) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
