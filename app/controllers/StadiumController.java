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
	
	public Result updateStadium(Long stadID){
		Stadium stadium = Stadium.find.byId(stadID);
		Form<Stadium> filledForm = formFactory.form(Stadium.class).fill(stadium);
		return ok(views.html.stadiumForm.render("Update", filledForm));
		
	}
	
	public Result deleteStadium(Long stadID){
		Stadium.delete(stadID);
		return redirect(routes.StadiumController.readStadiums());
	}

	public Result storeStadium(){
		Form<Stadium> stadiumForm = formFactory.form(Stadium.class);
		Form<Stadium> filledForm = stadiumForm.bindFromRequest();
		if (filledForm.hasErrors()){
			return ok(views.html.stadiumForm.render("Incorrect", filledForm));
		} else {
			Stadium st = filledForm.get();
			if (st.stadID == null){
			Stadium.createStadium(st);
		} else {
			Stadium.update(st);
			}
		return redirect(routes.StadiumController.readStadiums());
		}
	}
}
