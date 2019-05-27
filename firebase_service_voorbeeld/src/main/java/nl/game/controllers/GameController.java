package nl.game.controllers;

import com.google.cloud.firestore.DocumentSnapshot;

import nl.game.models.GameModel;
import nl.game.models.Model;
import nl.game.shared.Observer;
import nl.game.views.View;

public class GameController implements Controller{

	private Model gameModel;
	
	
	
	public GameController(Model gameModel) {
		this.gameModel = gameModel;
		//				
	}	
	
	public void update(DocumentSnapshot ds) {
		
		// Deze update wordt getriggerd na het wijzigen van de db.
		System.out.println("");
		System.out.println("update gekregen");
	}
	
	public void registerObserver(View v) {
		gameModel.registerObserver(v);
	}
	
}
