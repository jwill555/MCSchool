
import java.util.*;

public class PropertyDriver {
	
	public static void main(String[] args)
	{
		ManagementCompany testMC = new ManagementCompany("Campus Reality", "123-45-6789",new Property[100],0);
		ManagementCompany copyMC = new ManagementCompany(testMC);
		
		// True because all of the elements are equivlient to one another
		System.out.println(testMC.equals(copyMC));
		Property p = new Property("Jaydens Prop", "Gtown", 50000, "Jayden");
		testMC.addProperty(p);
		// False because of added property and extra property in properties 
		System.out.println(testMC.equals(copyMC));
		//Copy constuirctor and added to copyMC
		copyMC.addProperty(new Property(p));
		System.out.println(testMC.equals(copyMC));
		
		ManagementCompany testMC2 = new ManagementCompany("Campus Reality", "123-45-6789",new Property[100],0);
		Scanner sc = new Scanner(System.in);

		
		int userIn = 0;
		
		do
		{
			showMenu();
			System.out.print("Enter choice (1-4): ");
			userIn = sc.nextInt();
			
			switch (userIn)
			{
			case 1:
			{
				Property newProp = new Property();
				System.out.print("Enter property name: ");
				newProp.setPropertyName(sc.next());
				System.out.print("Enter city: ");
				newProp.setCity(sc.next());
				System.out.print("Enter monthly rent: ");
				newProp.setRentAmount(sc.nextDouble());
				System.out.print("Enter owner name: ");
				newProp.setOwner(sc.next());
				System.out.println("Property added at index " + testMC.getPropertyCount());
				testMC2.addProperty(newProp);
				break;
			}
			case 2:
			{
				System.out.println(testMC2.toString());
			}
			case 3:
			{
				System.out.printf("Total rent: $%.2f", testMC2.totalRent());
				System.out.println();
				break;
			}
			}
			
		} while (userIn != 4);
		sc.close();
		
		
	}
	
	public static void showMenu()
	{
		System.out.println("=======================================");
		System.out.println("Assignment 4: Property Manager");
		System.out.println("=======================================");
		
		System.out.println("1 - Add Property");
		System.out.println("2 - Display All Properties");
		System.out.println("3 - Show Total Rent");
		System.out.println("4 - Exit");
	}

}
