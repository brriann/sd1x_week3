package MovieDB;
import java.util.*;

public class Movie {

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
	
	private double rating;
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	public Movie(String name, ArrayList<Actor> actors, double rating) {
		this.name = name;
		this.actors = actors;
		this.rating = rating;
	}
	
	
	
	
	
	
}
