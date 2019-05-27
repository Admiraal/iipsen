package nl.game.controllers;

import com.google.cloud.firestore.DocumentSnapshot;

import nl.game.shared.Observer;
import nl.game.views.View;

public interface Controller {
	
	public void setView(View v);
	public void update(DocumentSnapshot ds);
	public void registerObserver(Observer v);
}
