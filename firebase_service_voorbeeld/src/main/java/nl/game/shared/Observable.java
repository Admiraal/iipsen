package nl.game.shared;

import nl.game.views.View;

public interface Observable {

	public void registerObserver(View v);
	
	public void unregisterObserver(View v);
	
	public void notifyObservers();
}
