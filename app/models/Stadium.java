package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Stadium extends Model {

	// Attributes
	@Id
	public Long stadID;

	@Required
	public String name;

	@Required
	public String address;

	@Required
	public int numberOfSeats;

	@Required
	public int numberOfExits;

	public String sponsor;

	@OneToMany(mappedBy = "stadium", cascade = CascadeType.REMOVE)
	public List<Game> games;

	// Finder
	public static Finder<Long, Stadium> find = new Finder<Long, Stadium>(Stadium.class);

	// get all stadiums
	public static List<Stadium> all() {
		return find.all();
	}

	// Constructor
	public static void createStadium(Stadium stadium) {
		stadium.save();
	}

	// Delete
	public static void delete(Long id) {
		find.ref(id).delete();
	}

	// Update
	public static void update(Stadium stadium) {
		stadium.update();
	}

	// Add Game
	public void addGame(Game game) {
		this.games.add(game);
		game.addStadium(this);
	}

	// Get all games
	public List<Game> getGames() {
		return this.games;
	}

}
