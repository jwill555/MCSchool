
import java.util.*;
public class PatientDriverApp 
{
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		
		Patient newPatient = inputPatient(inputScanner);
		
		displayPatient(newPatient);
		
		Procedure procedure1 = createProcedure1();
		Procedure procedure2 = createProcedure2();
		Procedure procedure3 = createProcedure3();
		
		displaySummary(procedure1,procedure2,procedure3);
		
	}
	public static Patient inputPatient(Scanner input)
	{
		Patient newPat = new Patient();
		System.out.print("Enter first name: ");
		newPat.setFirstName(input.next());
		
		System.out.print("Enter middle name: ");
		newPat.setMiddleName(input.next());
		
		System.out.print("Enter last name: ");
		newPat.setLastName(input.next());
		System.out.print("Enter street address: ");
		input.nextLine();
		newPat.setAddress(input.nextLine());
		System.out.print("Enter city: ");
		newPat.setCity(input.next());
		
		System.out.print("Enter state: ");
		newPat.setState(input.next());
		
		System.out.print("Enter zip: ");
		newPat.setZipCode(input.next());
		
		System.out.print("Enter phone number (###-###-####): ");
		newPat.setPhoneNumber(input.next());
		
		System.out.print("Enter emergency contact name: ");
		input.nextLine();
		newPat.setEmgContactName(input.nextLine());
		
		System.out.print("Enter emergency contact number: ");
		newPat.setEmgContactNum(input.next());
		return newPat;
		
	}
	public static Procedure createProcedure1()
	{
		Procedure procedure1 = new Procedure();
		procedure1.setPractitionerName("Dr.Irvine");
		procedure1.setDate ("07/20/2026");
		procedure1.setProcedureName("Physical Exam");
		procedure1.setChargeForProcedure(250.00);
		
		return procedure1;
	}
	public static Procedure createProcedure2() 
	{
		Procedure procedure2 = new Procedure("X-ray","07/20/26");
		procedure2.setPractitionerName("Dr.Jamison");
		procedure2.setChargeForProcedure(550.43);
		return procedure2;
	}
	public static Procedure createProcedure3() 
	{
		Procedure procedure3 = new Procedure("Blood Test","07/20/26","Dr.Smith",1400.75);
		
		return procedure3;
	}
	public static void displayPatient(Patient patient) 
	{
		System.out.println("Patient Information");
		System.out.println("-------------------");
		System.out.println("Name: " + patient.buildFullName());
		System.out.println("Address: " + patient.buildAddress());
		System.out.println("Phone Number: " + patient.getPhoneNumber());
		System.out.println("Emergency Contact: " + patient.buildEmergencyContact());
		System.out.println("Phone Valid: " + patient.isValidPhoneNumber());
		System.out.println("Emergency Phone Valid: " + patient.isValidEmgNumber());
		
		
	}
	public static void displayProcedure(Procedure procedure) 
	{
		System.out.print(procedure.getProcedureName() + "    " + procedure.getDate() + "   " + procedure.getPractitionerName() + "    ");
		System.out.printf("$%,.2f  ", procedure.getCharge());
		System.out.println(procedure.getChargeCategory());
		
	}
	public static void displayProcedureTable(Procedure p1, Procedure p2, Procedure p3) 
	{
		displayProcedure(p1);
		displayProcedure(p2);
		displayProcedure(p3);
	}
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3)
	{
		return p1.getCharge() + p2.getCharge() + p3.getCharge();
	}
	public static double calculateAverageCharge(Procedure p1, Procedure p2, Procedure p3)
	{
		return (p1.getCharge() + p2.getCharge() + p3.getCharge()) / 3;
	}
	public static Procedure findHighestChargeProcedure(Procedure p1, Procedure p2, Procedure p3)
	{
		Procedure largerProcedure;
		
		if (p1.getCharge() >= p2.getCharge())
		{
			largerProcedure = p1;
		}
		else
		{
			largerProcedure = p2;
		}
		if (largerProcedure.getCharge() > p3.getCharge())
		{
			return largerProcedure;
		}
		else
		{
			return p3;
		}
	}
	public static int  countExpensiveProcedures(Procedure p1, Procedure p2, Procedure p3) 
	{
		int expensivePurchases = 0;
		
		if (p1.isExpensiveProcedure())
		{
			expensivePurchases++;
		}
		if (p2.isExpensiveProcedure())
		{
			expensivePurchases++;
		}
		if (p3.isExpensiveProcedure())
		{
			expensivePurchases++;
		}
		
		return expensivePurchases;
	}
	public static void displaySummary(Procedure p1, Procedure p2, Procedure p3) 
	{
		System.out.println("Procedure     Date    Practitioner   Charge    Category");
		System.out.println("-------------------------------------------------------");
		displayProcedureTable(p1,p2,p3);
		System.out.printf("Total Charges: $%,.2f\n", calculateTotalCharges(p1,p2,p3));
		System.out.printf("Total Charges: $%,.2f\n", calculateAverageCharge(p1,p2,p3));
		System.out.println("Highest Charge Procedure: " + findHighestChargeProcedure(p1,p2,p3).getProcedureName());
		System.out.println("Number of Expensive Procedures: " + countExpensiveProcedures(p1,p2,p3));
		System.out.println("\n The program was developed by a Student:  Jayden Williams 09/27/26");
	}
}
