package MovieDB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieDatabaseTest {
	
	public MovieDatabase db;

	@BeforeEach
	void setUp() throws Exception {
		db = new MovieDatabase();
	}

	@Test
	void testAddMovie() {
		String[] actors = new String[] {"andy", "tim", "john"};
		String[] actors2 = new String[] {"andy", "tim", "jill"};
		
		db.addMovie("movieName", actors);
		
		assertEquals(db.getMovieList().size(), 1);
		assertEquals(db.getActorList().size(), 3);
		
		db.addMovie("movieName", actors);
		
		assertEquals(db.getMovieList().size(), 1);
		assertEquals(db.getActorList().size(), 3);
		
		db.addMovie("movieName2", actors2);
		
		assertEquals(db.getMovieList().size(), 2);
		assertEquals(db.getActorList().size(), 4);
	}

	@Test
	void testAddRating() {
		String[] actors = new String[] {"aa", "bb"};
		db.addMovie("rateMovie", actors);
		
		Movie nullTest = null;
		
		for (Movie movie : db.getMovieList()) {
			if (movie.getName().equals("rateMovie")) {
				nullTest = movie;
			}
		}
		
		assertEquals(nullTest.getRating(), null);
		
		db.addRating("rateMovie", 5.5);
		
		Movie ratedTest = null;
		
		for (Movie movie : db.getMovieList()) {
			if (movie.getName().equals("rateMovie")) {
				ratedTest = movie;
			}
		}
		
		Double rating = 5.5;
		assertEquals(ratedTest.getRating(), rating);
	}

	@Test
	void testUpdateRating() {
		String[] actors = new String[] {"aa", "bb"};
		db.addMovie("rateMovie", actors);
		
		db.addRating("rateMovie", 5.5);
		
		db.updateRating("rateMovie", 6.6);
		
		Movie ratedTest = null;
		
		for (Movie movie : db.getMovieList()) {
			if (movie.getName().equals("rateMovie")) {
				ratedTest = movie;
			}
		}
		Double rating = 6.6;
		assertEquals(ratedTest.getRating(), rating);
	}

	@Test
	void testGetBestActor() {
		String[] actors = new String[] {"andy", "tim", "john"};
		String[] actors2 = new String[] {"andy", "tim", "jill"};
		String[] actors3 = new String[] {"highguy"};
		
		db.addMovie("movie1", actors);
		
		db.addMovie("movie2", actors2);
		
		db.addMovie("movie3", actors3);
		
		db.addRating("movie1", 2.2);
		
		db.addRating("movie2", 9.9);
		db.addRating("movie3", 10.0);
		
		assertEquals(db.getBestActor(), "highguy");
	}

	@Test
	void testGetBestMovie() {
		String[] actors = new String[] {"aa", "bb"};
		
		db.addMovie("rateMovie", actors);
		
		db.addRating("rateMovie", 5.5);
		
		db.addMovie("rateMovie2", actors);
		
		db.addRating("rateMovie2", 6.6);
		
		db.updateRating("rateMovie", 7.7);
		assertEquals(db.getBestMovie(), "rateMovie");
	}

}
