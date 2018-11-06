package MovieDB;
import java.io.File;
import java.io.FileNotFoundException;
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
		}
		
		// for new actors : CREATE THEM, add them to movie, add movie to them
		ArrayList<Movie> thisMovie = new ArrayList<Movie>();
		thisMovie.add(movie);
		
		for (String newActor : newActors) {
			Actor newActordb = new Actor(newActor, thisMovie);
			actorList.add(newActordb);
			movie.getActors().add(newActordb);
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
		Collections.sort(actorList);
		return actorList.get(actorList.size() - 1).getName();
	}
	
	public String getBestMovie() {
		
		Collections.sort(movieList);
		return movieList.get(movieList.size() - 1).getName();
	}
	
	public static void main(String[] args) {
		
		MovieDatabase db = new MovieDatabase();
		
		File file = new File("movies.txt");
		try {
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				List<String> lineList = Arrays.asList(line.split(","));
				
				if (lineList.get(0).trim().length() > 0) {
					Actor lineActor = new Actor(lineList.get(0), new ArrayList<Movie>());
					
					ArrayList<String> lineMovies = new ArrayList<String>();
					
					for (int i = 1; i < lineList.size(); i++) {
						String lineMovie = lineList.get(i).trim();
						lineMovies.add(lineMovie);
					}
					
					ArrayList<String> existingMovies = new ArrayList<String>();
					ArrayList<String> newMovies = new ArrayList<String>();
					
					// break line Movies into new and existing
					for (String lineMovie : lineMovies) {
						int counter = db.movieList.size();
						boolean existing = false;
						if (counter > 0) {
							for (Movie movie : db.movieList) {
								if (movie.getName().equals(lineMovie)) {
									existing = true;
									existingMovies.add(lineMovie);
								}
								counter--;
								if (counter == 0 && !existing) {
									newMovies.add(lineMovie);
								}
							}
						} else {
							newMovies.add(lineMovie);
						}
					}
					
					// for existing movies : add Actor to movie, add movie to Actor
					
					for (String existing : existingMovies) {
						for (Movie movie : db.movieList) {
							if (movie.getName().equals(existing)) {
								movie.getActors().add(lineActor);
								lineActor.getMovies().add(movie);
							}
						}
					}
					
					// for new movies : add Movie to db, add Actor to movie, add movie to Actor
					for (String newMovie : newMovies) {
						Movie newMovieObj = new Movie(newMovie, new ArrayList<Actor>(), null);
						newMovieObj.getActors().add(lineActor);
						lineActor.getMovies().add(newMovieObj);
						db.movieList.add(newMovieObj);
					}
					db.actorList.add(lineActor);
				}
			}
			System.out.println("movie import done");
			input.close();
			
		}
		catch (FileNotFoundException ex) {
			System.out.println("Movies file not found.");
		}
		
		File file2 = new File("ratings.txt");
		try {
			Scanner input = new Scanner(file2);
			input.nextLine();
			while (input.hasNextLine()) {
				String line = input.nextLine();
				List<String> lineList = Arrays.asList(line.split("\\t"));
				for (Movie movie : db.getMovieList()) {
					if (movie.getName().equals(lineList.get(0))) {
						movie.setRating(Double.parseDouble(lineList.get(1)));
					}
				}
			}
			System.out.println("Ratings import done");
			input.close();
			System.out.println(db.getBestActor());
			System.out.println(db.getBestMovie());
			
		}
		catch (FileNotFoundException ex) {
			System.out.println("Ratings file not found.");
		}
	}
}
