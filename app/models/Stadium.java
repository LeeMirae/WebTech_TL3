package models;

import java.util.List;
import javax.persistence.*;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Stadium extends Model {
	private String name;
	private String address;
	private int seats;
	private int entrances;
	private String sponsor;

	// private List<Game> gameList;

	public Stadium(String name, String address, int seats, int entrances) {
		this.name = name;
		this.address = address;
		this.seats = seats;
		this.entrances = entrances;

	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	// public void addPartie(Game game){
	// gameList.add(game);
	// }

	//Attributes
	
	@Id
	public Long stadId;
	
	@Required
	public String name;
	
	@Required
	public String adresse;
	
	@Required
	public int numberOfSeats;
	
	@Required
	public int numberOfExits;
	
	public String sponsor;
	
	
	@OneToMany(mappedBy="stadium",cascade=CascadeType.REMOVE)
	public List<Game> games;
	
	
	//Finder
	public static Finder<Long, Stadium> find = new Finder<Long,Stadium>(Stadium.class);
	
	//get all stadiums
	public static List<Stadium> all() {
		return find.all();
	}
	
	//Constructor
	public static void createStadium(Stadium stadium){
		stadium.save();
	}
	
	//Delete
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	//Update
	public static void update(Stadium stadium){
		stadium.update();
	}
	
	//Add Game
	 public void addGame(Game game){
		this.games.add(game);
		game.addStadium(this);
	 }
	 
	 //Get all games
	 public List<Game> getGames(){
		 return this.games;
	 }
}