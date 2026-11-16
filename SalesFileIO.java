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

import java.util.*;
import java.io.*;

public class SalesFileIO {

	public static double[][] readSalesData(String fileName) throws IOException {
		File newFile = new File(fileName);

		Scanner sc = new Scanner(newFile);

		int index = -1;

		ArrayList<String> listOfInts = new ArrayList<>();

		while (sc.hasNextLine()) {
			String lineOfInt = sc.nextLine();
			listOfInts.add(lineOfInt);
			index++;

		}
		System.out.println(index);
		double[][] data = new double[index][];

		for (int i = 0; i < index; i++) {
			String[] listSplit = listOfInts.get(i).split(" ");

			data[i] = new double[listSplit.length];
			for (int innerI = 0; innerI < listSplit.length; innerI++) {
				data[i][innerI] = Double.parseDouble(listSplit[innerI]);
			}

		}

		sc.close();
		return data;
	}

	public static void writeSummary(String fileName, double[][] data) throws FileNotFoundException {
		PrintWriter outputFile = new PrintWriter(fileName);

		outputFile.println("Total sales: " + SalesDataUtility.getTotal(data));
		outputFile.println("Average sale: " + SalesDataUtility.getAverage(data));
		// outputFile.println("Highest sale: " + newSDU.getHighestInArray(data));
		// outputFile.println("Lowest sale: " + newSDU.getLowestInArray(data));

		for (int i = 0; i < data.length; i++) {
			outputFile.println("Row " + i + " total: " + SalesDataUtility.getRowTotal(data, i));
		}
		for (int i = 0; i < data.length; i++) {
			outputFile.println("Column " + i + " total: " + SalesDataUtility.getColumnTotal(data, i));
		}
		outputFile.close();
	}

}
