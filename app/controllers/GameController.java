package controllers;

import javax.inject.Inject;

import models.Game;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class GameController extends Controller {

	Game game = new Game();

	@Inject
	static FormFactory formFactory;

	private static Form<Game> gameForm;

	public static Result games() {
		gameForm = formFactory.form(Game.class);
		return ok(views.html.games.render(Game.all(), gameForm));
	}

	public Result createGame() {
		gameForm = formFactory.form(Game.class);
		Form<Game> filledForm = gameForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.games.render(Game.all(), filledForm));
		} else {
			Game.createGame(filledForm.get());
			return redirect(routes.GameController.games());
		}
	}

	public Result readGames() {
		return ok(views.html.games.render(Game.all()));
	}

	public Result deleteGame(Long gameId) {
		game.delete(gameId);
		return redirect(routes.GameController.games());
	}

	public Result findGame(Long gameId) {
		return TODO;
	}

	public Result updateGame(Long gameId) {
		return TODO;
	}

}
