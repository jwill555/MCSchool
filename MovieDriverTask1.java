
import java.util.*;

public class MovieDriverTask1 {
	
	
	public static void main(String[] args)
	{
		Scanner Sc = new Scanner(System.in);
		
		Movie movie1 = new Movie();
		
		String titleOfMovie,rating;
		int ticketsSold;
		
		System.out.println("Enter the name of a movie");
		titleOfMovie = Sc.nextLine();
		System.out.println("Enter the rating of the movie:");
		rating = Sc.next();
		System.out.println("Enter the number of tickets sold for this movie");
		ticketsSold = Sc.nextInt();
		
		movie1.setRating(rating);
		movie1.setTitle(titleOfMovie);
		movie1.setSoldTickets(ticketsSold);
		
		System.out.println(movie1.toString());
	}

}
