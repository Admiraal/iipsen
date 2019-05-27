package nl.game.models;

import java.util.ArrayList;
import java.util.List;

import nl.game.shared.Observable;
import nl.game.views.View;

public class GameModel implements Observable, Model{

	private List<View> observers = new ArrayList<View>();
	
	
	public GameModel() {
		// TODO Auto-generated constructor stub
	}
	

	public void registerObserver(View v) {
		this.observers.add(v);
		
	}

	public void unregisterObserver(View v) {
		this.observers.remove(v);
		
	}

	public void notifyObservers() {
		
		// Elke View waarschuwen dat er een wijziging is in de 
		for (int i = 0; i < this.observers.size(); i++) {
			
			this.observers.get(i).update();
		}		
	}

}
