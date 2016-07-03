package controllers;

import javax.inject.Inject;

import models.Stadium;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class StadiumController extends Controller {
	
	@Inject
	private FormFactory formFactory;
	
	
	public Result createStadium(){
		return ok(views.html.stadiumForm.render("Create", formFactory.form(Stadium.class)));
		
	}
	
	public Result readStadiums(){
		return ok(views.html.stadiums.render(Stadium.all()));
	}
	
	public Result updateStadium(Long stadId){
		return TODO;
	}
	
	public Result deleteStadium(Long stadID){
		return TODO;
	}

	public Result storeStadium(){
		return TODO;
		
	}
	
}
