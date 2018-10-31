package MovieDB;
import java.util.*;

public class Actor {
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private ArrayList<Movie> movies;
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	
	public Actor(String name, ArrayList<Movie> movies) {
		this.name  = name;
		this.movies = movies;
	}
}
