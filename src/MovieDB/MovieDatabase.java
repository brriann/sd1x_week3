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
		
		// if movie exists do nothing
		for (Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				return;
			}
		}
		
		// if not, make new movie
		ArrayList<Actor> empty = new ArrayList<Actor>();
		Movie movie = new Movie(name, empty, null);
		
		// handle actors input array
		ArrayList<String> newActors = new ArrayList<String>();
		ArrayList<Actor> existingActors = new ArrayList<Actor>();
		
		for (String actor : actors) {
			int counter = actorList.size();
			boolean existing = false;
			if (counter > 0) {
				for (Actor dbActor : actorList) {
					if (dbActor.getName().equals(actor)) {
						existingActors.add(dbActor);
						existing = true;
					}
					counter--;
					if (counter == 0 && !existing) {
						newActors.add(actor);
					}
				}
			} else {
				newActors.add(actor);
			}
		}
		
		// for existing actors : add them to movie, add movie to them
		for (Actor existing : existingActors) {
			
			existing.getMovies().add(movie);
			
			/*ArrayList<Movie> actorMovies = existing.getMovies();
			actorMovies.add(movie);
			existing.setMovies(actorMovies);*/
		}
		
		// for new actors : CREATE THEM, add them to movie, add movie to them
		ArrayList<Movie> thisMovie = new ArrayList<Movie>();
		thisMovie.add(movie);
		
		for (String newActor : newActors) {
			Actor newActordb = new Actor(newActor, thisMovie);
			actorList.add(newActordb);
			movie.getActors().add(newActordb);
			
			/*ArrayList<Actor> movieActors2 = movie.getActors();
			movieActors2.add(newActordb);
			movie.setActors(movieActors2);*/
		}
		movieList.add(movie);
	}
	
	public void addRating(String name, Double rating) {
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
	
	public void updateRating(String name, Double newRating) {
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
		return "asdf";
	}
	
	public String getBestMovie() {
		return "asdf";
	}
	
	public static void main(String[] args) {
		MovieDatabase db = new MovieDatabase();
		String[] actors = new String[] {"aa", "bb"};
		db.addMovie("movie1", actors);
		
		db.addRating("movie1", 5.5);
		db.updateRating("movie1", 6.6);
	}
}
