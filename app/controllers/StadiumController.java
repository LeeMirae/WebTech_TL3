package controllers;

import javax.inject.Inject;

import models.Stadium;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class StadiumController extends Controller {
	
	@Inject
	FormFactory formFactory;
	
	private Form<Stadium> stadiumForm;
	
	
	public Result createStadium(){
		return TODO;
		
	}
	
	public Result readStadiums(){
		return TODO;
	}
	
	public Result updateStadium(String name){
		return TODO;
	}
	
	public Result deleteStadium(String name){
		return TODO;
	}

	public Result storeStadium(){
		return TODO;
		
	}
	
}
