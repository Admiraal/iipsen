package nl.game.controllers;

import com.google.cloud.firestore.DocumentSnapshot;

import nl.game.models.GameModel;
import nl.game.models.Model;
import nl.game.shared.Observer;
import nl.game.views.View;

public class GameController implements Controller{

	private Model gameModel;
	private View gameView;
	
	
	public GameController(Model gameModel) {
		this.gameModel = gameModel;
				
	}
	
	
	public void setView(View view) {
		this.gameView = view;
	}
	
	
	public void update(DocumentSnapshot ds) {
		
		// Deze update wordt getriggerd na het 
		System.out.println("");
		System.out.println("update gekregen");
	}
	
	public void registerObserver(Observer v) {
		gameModel.registerObserver(gameView);
	}
	
}
