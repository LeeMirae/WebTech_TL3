package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

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
	
	
	
	
	
	
}
