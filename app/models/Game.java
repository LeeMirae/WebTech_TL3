package models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Game extends Model {
	
	//Attributes

	@Id
	public Long gameId;
	
	@Required
	String homeTeamName;
	
	@Required
	String guestTeamName;
	
	@Required
	Date date;
	
	@ManyToOne
	private Stadium stadium;
	
	
	//Finder
	public static Finder<Long, Game> find = new Finder<Long, Game>(Game.class); 
	
	
	//Get All Games
	public static List<Game> all(){
		return find.all();
	}
	
	//Constructor
	public static void createGame(Game game){
		game.save();
	}
	
	//Delete
	public void delete(Long id) {
		find.ref(id).delete();
	}
	
	//Update
	public void update(Game game){
		game.update();
	}

	//Add a stadium
	public void addStadium(Stadium st) {
		if (stadium == null){
		st.addGame(this);
		}
	}
	
	//Get stadium
	public Stadium getStadium(){	
		return this.stadium;
	}
	
	
}
