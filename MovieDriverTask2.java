
import java.util.*;

public class MovieDriverTask2 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String userToContinue;
		
		do 
		{
			Movie movie1 = new Movie();
			System.out.println("Enter the name of a movie");
			movie1.setTitle(sc.nextLine());
			
			System.out.println("Enter the rating of the movie");
			movie1.setRating(sc.next());
			
			System.out.println("Enter the number of tickets sold for this movie");
			movie1.setSoldTickets(sc.nextInt());
			
			System.out.println(movie1.toString());
			
			System.out.println("Do you want to enter another? (y or n)");
			userToContinue = sc.next();
			sc.nextLine();
			
		} while (userToContinue.equals("y"));
		System.out.println("Goodbye");
	}

}
