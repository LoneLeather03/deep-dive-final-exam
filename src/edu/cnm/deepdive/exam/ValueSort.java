package edu.cnm.deepdive.exam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ValueSort {

	private static final String OUTPUT = "test-output.dat";
	private static final String INPUT = "test-input.dat";
	private static float counter = 0.0f;
	private static float sum = 0.0f;
	
	

	public static void main(String[] args) {
		Reader dataReader = new Reader(INPUT);
		Float[][] data = dataReader.valueList;

		for (Float[] shuffleLine : data) {
			Collections.shuffle(Arrays.asList(shuffleLine));
		}
		Arrays.asList(data).sort((array1, array2) -> {
			if (Collections.min(Arrays.asList(array1)) < (Collections.min(Arrays.asList(array2)))) {
				return -1;
			} else if ((Collections.min(Arrays.asList(array1)) > (Collections.min(Arrays.asList(array2))))) {
				return 1;
			} else {
				return 0;
			}
		});
		writeData(OUTPUT, data);

	}
	
	


	private static void writeData(String DATA_OUTPUT, Float[][] shuffled) {

		try (FileOutputStream stream = new FileOutputStream(DATA_OUTPUT);
				OutputStreamWriter writer = new OutputStreamWriter(stream);
				PrintWriter printer = new PrintWriter(writer);) {
			for (Float[] writeShuffledArray : shuffled) {
				int i = 1;
				for (Float number : writeShuffledArray) {
					counter++;
					sum += number;
					if (i++ == writeShuffledArray.length) {
						printer.printf("%.3f", number);

					} else {
						printer.printf("%.3f|", number);
					}
				}
				printer.println();
			}
			float averageValue = (sum / counter);
			printer.print(averageValue);
		}

		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}


public class Reader {

	public Float [][] valueList;
	public Reader(String file) {
		
		try (
				FileReader reader = new FileReader(file);
				BufferedReader buffer = new BufferedReader(reader);
				) {
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
			valueList = work.toArray(new Float [0][]);
			
		}catch (NumberFormatException ex) {
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}