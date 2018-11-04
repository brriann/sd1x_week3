package MovieDB;
import java.util.*;

public class Actor implements Comparable {
	
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
	
	public int compareTo(Object compare) {
		
		int myCount = this.getMovies().size();
		Double mySum = 0.0;
		int theirCount = ((Actor)compare).getMovies().size();
		Double theirSum = 0.0;
		
		Double myAvg = 0.0;
		Double theirAvg = 0.0;
		
		for (Movie movie : this.getMovies()) {
			if (movie.getRating() != null) {
				mySum += movie.getRating();
			} 
		}
		if (myCount > 0) {
			myAvg = mySum / myCount;
		}
		
		for (Movie movie : ((Actor)compare).getMovies()) {
			if (movie.getRating() != null) {
				theirSum += movie.getRating();
			} 
		}
		if (theirCount > 0) {
			theirAvg = theirSum / theirCount;
		}
		
		if (myAvg > theirAvg) {
			return 1;
		} else if (myAvg == theirAvg) {
			return 0;
		} else {
			return -1;
		}
		
	}
}
