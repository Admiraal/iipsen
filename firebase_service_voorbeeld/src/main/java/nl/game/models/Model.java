package nl.game.models;

import nl.game.views.View;

public interface Model {
	
	public void registerObserver(View v);
	public void unregisterObserver(View v);
	public void notifyObservers();	
}
