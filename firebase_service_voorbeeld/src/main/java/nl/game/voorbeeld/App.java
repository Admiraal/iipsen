package nl.game.voorbeeld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import nl.game.controllers.Controller;
import nl.game.controllers.GameController;
import nl.game.models.GameModel;
import nl.game.models.Model;
import nl.game.services.FirebaseService;
import nl.game.views.GameView;
import nl.game.views.View;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	public App() {
		
		// Hier maken we een game identifier en een game-token aan. 
		String gameIdentifier = "GY2UYU4D";
		String gameToken = "HGJTF";
		
		// We maken hier een hashmap met de gegevens van de spelers.
		Map playerData = new HashMap<String, String>();
		playerData.put("Player1", "Floris");
		playerData.put("Player2", "Michiel");
		playerData.put("Player3", "Josh");
		playerData.put("Player4", "Koen");
		
		// We maken hier de HashMap met de "game" gegevens.
		Map dataForFirebase = new HashMap<String, Object>();
		dataForFirebase.put("token", gameToken);		
		dataForFirebase.put("players", playerData);
		dataForFirebase.put("current_player", "Player2");
		
		
		FirebaseService fbService = new FirebaseService();		// Gebruik de firebase server voor contact met firebase.
		fbService.set(gameIdentifier, dataForFirebase);			// Game-gegevens opslaan.
		
				
		
		
		
		// Maken van de MVC
		Model gameModel = new GameModel();
		Controller gameController = new GameController(gameModel);	// De EventListener kan hier..(denk ik)
		View gameView = new GameView(gameController);
		
		
		
		
		// Luisteren naar de Listener. Verplaats dit naar een controller.
		fbService.listen(gameIdentifier, gameController);
		
		
		try {
			this.waitForFirebaseObservable(10000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    public static void main( String[] args )
    {
        new App();
    }
    
    public synchronized void waitForFirebaseObservable(int ms) throws InterruptedException {
		
		// Deze methode gebruiken we alleen om het programma niet te laten beeïndigen.
		// Zodat we kunnen 'luisteren' naar de updates.
		
		int counter = 0;
		for (int i = 0; i < ms; i++) {
			
			if(counter % 1000 == 0) { 
				System.out.print(".");
			}
			this.wait(1);
			counter++;
		}
		System.out.println("Exiting program");
	}
}
