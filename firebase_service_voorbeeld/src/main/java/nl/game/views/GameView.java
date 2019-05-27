package nl.game.views;

import nl.game.controllers.Controller;
import nl.game.controllers.GameController;
import nl.game.models.GameModel;
import nl.game.models.Model;
import nl.game.shared.Observer;

public class GameView implements Observer, View{

	
	private Controller gameController;
	
	public GameView(Controller controller) {
		this.gameController = controller;
		
		gameController.registerObserver(this);
	}

	public void update() {
		// Reageer hier op de update..		
	}

}
