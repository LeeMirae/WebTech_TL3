package controllers;

import javax.inject.Inject;

import models.Game;
import models.Stadium;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class GameController extends Controller {

	@Inject
	private FormFactory formFactory;


	public Result games() {
		return ok(views.html.games.render(Game.all()));
	}

	public Result createGame() {
		return ok(views.html.gameForm.render("Create", formFactory.form(Game.class)));
	}

	public Result readGames() {
		return ok(views.html.games.render(Game.all()));
	}

	public Result deleteGame(Long gameId) {
		Game.delete(gameId);
		return redirect(routes.GameController.games());
	}

	public Result findGame(Long gameId) {
		return TODO;
	}

	public Result updateGame(Long gameId) {
		return TODO;
	}
	
	public Result storeGame(){
		return TODO;
	}

}
