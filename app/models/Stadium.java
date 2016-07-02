package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Stadium extends Model {

	//Attributes
	
	@Required
	String name;
	
	@Required
	String adresse;
	
	@Required
	int numberOfSeats;
	
	@Required
	int numberOfexits;
	
	String sponsor;
	
	
	@OneToMany(mappedBy="stadium",cascade=CascadeType.ALL)
	public List<Game> games;
	
	
	//Methods
	
	//Finder
	public static Finder<String, Stadium> find = new Finder<String, Stadium>(Stadium.class);
	
	//GetAll
	public static List<Stadium> all() {
		return find.all();
	}
	
	//Constructor
	public static void createStadium(Stadium stadium){
		stadium.save();
	}
	
	//Delete
	public void delete(String name){
		find.ref(name).delete();
	}
	
	//Update
	public void update(String name){
		find.ref(name).update();
	}
	
}