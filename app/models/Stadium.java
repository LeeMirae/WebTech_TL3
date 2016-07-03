package models;

import com.avaje.ebean.Model;

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

}