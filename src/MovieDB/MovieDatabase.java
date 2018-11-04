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
		for (Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				return;
			}
		}
		ArrayList<String> newActors = new ArrayList<String>();
		ArrayList<Actor> existingActors = new ArrayList<Actor>();
		for (String actor : actors) {
			int counter = getActorList().size();
			for (Actor dbActor : getActorList()) {
				if (dbActor.getName().equals(actor)) {
					existingActors.add(dbActor);
				}
				counter--;
				if (counter == 0) {
					newActors.add(actor);
				}
			}
		}
	}
	
	public void addRating(String name, double rating) {
		Movie movieToRate = null;
		for (Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				movieToRate = movie;
			}
		}
		if (movieToRate != null) {
			movieToRate.setRating(rating);
		}
	}
	
	public void updateRating(String name, double newRating) {
		Movie movieToRate = null;
		for (Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				movieToRate = movie;
			}
		}
		if (movieToRate != null) {
			movieToRate.setRating(newRating);
		}
	}
	
	public String getBestActor() {
		
	}
	
	public String getBestMovie() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
