package edu.cnm.deepdive.exam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

/* Class that shuffles and sorts input from file **/
public class ValueSort {

	private static final String OUTPUT = "test-output.dat";
	private static final String INPUT = "test-input.dat";
	private static float counter = 0.0f;
	private static float sum = 0.0f;
	
/* Main method calls readFile class to read file, initializes float arrays, shuffles and sorts each line. **/
	public static void main(String[] args) {
		ReadFile dataReader = new ReadFile(INPUT);
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

	/* writeData method writes output to file with three decimal places to the right of each value, 
	 * a vertical bar delimiter and iterates through the values adding them together and dividing by
	 *  the total number of values to find the average value then print it on the last line. **/
	private static void writeData(String DATA_OUTPUT, Float[][] shuffled) {

		try (FileOutputStream stream = new FileOutputStream(OUTPUT);
				OutputStreamWriter write = new OutputStreamWriter(stream);
				PrintWriter print = new PrintWriter(write);) {
			for (Float[] writeShuffledArray : shuffled) {
				int i = 1;
				for (Float number : writeShuffledArray) {
					counter++;
					sum += number;
					if (i++ == writeShuffledArray.length) {
						print.printf("%.3f", number);

					} else {
						print.printf("%.3f|", number);
					}
				}
				print.println();
			}
			float averageValue = (sum / counter);
			print.print(averageValue);
		}

		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

}