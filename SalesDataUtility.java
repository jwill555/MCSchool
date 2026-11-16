/*
* Class: CMSC203
* Instructor: Farnaz Eivazi
* Description: Sales Controller
* Due:  11/15/26
* Platform/compiler:
* I pledge that I have completed the programming
* assignment independently. I have not copied the code
* from a student or any source. I have not given my
code
* to any student.
Print your Name here: Jayden Williams
*/

public class SalesDataUtility {

	public static double getTotal(double[][] data) {
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			for (int innerI = 0; innerI < data[i].length; innerI++) {
				total += data[i][innerI];
			}
		}

		return total;
	}

	public static double getAverage(double[][] data) {
		double average = 0;

		int length = 0;

		for (int i = 0; i < data.length; i++) {
			for (int innerI = 0; innerI < data[i].length; innerI++) {
				average += data[i][innerI];
			}
			length += data[i].length;
		}

		return average / length;
	}

	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		if (data.length > row) {
			for (int i = 0; i < data[row].length; i++) {
				total += data[row][i];
			}
			return total;
		}
		return -1;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {
				total += data[i][col];
			}
		}
		return total;

	}

	public static double getHighestInRow(double[][] data, int row) {
		double highest = -1;
		if (data.length > row) {
			highest = data[row][0];
			for (int i = 1; i < data[row].length; i++) {
				if (highest < data[row][i]) {
					highest = data[row][i];
				}
			}
		}

		return highest;
	}

	public static double getLowestInRow(double[][] data, int row) {
		double lowest = -1;
		if (data.length > row) {
			lowest = data[row][0];
			for (int i = 1; i < data[row].length; i++) {
				if (lowest > data[row][i]) {
					lowest = data[row][i];
				}
			}
		}

		return lowest;
	}

	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int innerI = 0; innerI < data[i].length; innerI++) {
				if (highest < data[i][innerI]) {
					highest = data[i][innerI];
				}
			}
		}

		return highest;
	}

	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int innerI = 0; innerI < data[i].length; innerI++) {
				if (lowest > data[i][innerI]) {
					lowest = data[i][innerI];
				}
			}
		}

		return lowest;
	}

}
