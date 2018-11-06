package MovieDB;
import java.util.*;

public class Movie implements Comparable {

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private ArrayList<Actor> actors;
	public ArrayList<Actor> getActors() {
		return actors;
	}
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	
	private Double rating;
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	
	public Movie(String name, ArrayList<Actor> actors, Double rating) {
		this.name = name;
		this.actors = actors;
		this.rating = rating;
	}
	
	public int compareTo(Object compare) {
		Double compareRating = ((Movie)compare).getRating();
		if (this.rating == null && compareRating == null) return 0;
		if (this.rating == null) return -1;
		if (compareRating == null) return 1;
		if (this.rating > compareRating) return 1;
		else if (this.rating == compareRating) return 0;
		else return -1;
	}
	
	
	
	
	
}
