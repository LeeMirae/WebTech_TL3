package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Game extends Model {
	
	//Attributes

	@Required
	String homeTeamName;
	
	@Required
	String guestTeamName;
	
	@Required
	Date date;
	
	@ManyToOne (cascade = CascadeType.ALL)
	public Stadium stadium;
	
	
	//Methods
	
	public static Finder<String, Game> find = new Finder<String, Game>(Game.class); 
	
	
	//GetAll
	public static List<Game> all(){
		return find.all();
	}
	
	//Constructor
	public static void createGame(Game game,Stadium stadium){
		game.save();
	}
	
	//Delete
	public void delete(Game game) {
		game.delete();
	}
	
	//Update
	public void update(Game game){
		game.update();
	}
}
