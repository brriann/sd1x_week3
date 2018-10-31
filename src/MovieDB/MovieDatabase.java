package MovieDB;
import java.util.*;

public class MovieDatabase {

	private ArrayList<Movie> movieList;
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	private ArrayList<Actor> actorList;
	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	
	public MovieDatabase() {
		this.movieList = new ArrayList<Movie>();
		this.actorList = new ArrayList<Actor>();
	}
	
	public void addMovie(String name, String[] actors) {
		
	}
	
	public void addRating(String name, double rating) {
		
	}
	
	public void updateRating(String name, double newRating) {
		
	}
	
	public String getBestActor() {
		
	}
	
	public String getBestMovie() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
