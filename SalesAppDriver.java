import java.io.IOException;
import java.util.*;

public class SalesAppDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String fileToReadFrom = "";
		String fileToWriteFrom = "";

		double[][] numbers;
		try {

			System.out.println("What file would you like the program to read from: ");

			fileToReadFrom = sc.nextLine();

			System.out.println("What file would you like the program to write from: ");

			fileToWriteFrom = sc.nextLine();

			System.out.println("Attempting to read sales data from " + fileToReadFrom);

			numbers = SalesFileIO.readSalesData(fileToReadFrom);

			System.out.println("Writing summary to " + fileToWriteFrom);
			SalesFileIO.writeSummary(fileToWriteFrom, numbers);

		} catch (IOException e) {
			System.out.println(fileToReadFrom + " does not exist");
			e.printStackTrace();
		}

		sc.close();

	}

}
