# deep-dive-final-exam
Final exam for deep dive coding bootcamp.
Program that reads input file, shuffles values in each row, sorts the collection of rows by value in ascending order and writes the sorted collection to an output file.
Program has two classes. The ReadFile class reads the input file. The ValueSort class has methods for shuffling, sorting, writing to an output file and determining the average value of all elements.

The ReadFile class has a readFile method that reads the file.

The writeData method writes output to file with three decimal places to the right of each value, a vertical bar delimiter and iterates through the values adding them together and dividing by the total number of elements to find the average value then print it on the last line.

The Main method calls readFile class to read file, initializes float arrays, shuffles/sorts each line and calls writeData method to write output file.
