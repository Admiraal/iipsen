package nl.hsleiden.iipsen.firebase_observable;

import java.io.IOException;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.firebase.database.annotations.Nullable;

/**
 * Demonstratie van cloud firestore met eventlistener.
 *
 */
public class App 
{
	
	public App() throws IOException, InterruptedException {
		
		Database setup = new Database();
		Firestore db = setup.getFirestoreDatabase();
		
		DocumentReference docRef = db.collection("sampleData").document("inspiration");
		
		// De listener 
		docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {

			public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirestoreException error) {
				if (error != null) {
					System.err.println("Listen failed: " + error);
					return;
				}
				
				if (snapshot != null && snapshot.exists()) {
					
					System.out.println("Current data: " + snapshot.getData());
				} else {
					System.out.print("Current data: null");
				}
				
			}
		});
		
		
		
		this.waitForFirebaseObservable(100000);
	}
	
	
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        new App();
    }
    
    

	
	public synchronized void waitForFirebaseObservable(int ms) throws InterruptedException {
		
		// Deze methode gebruiken we alleen om het programma niet te laten beeïndigen.
		// Zodat we kunnen 'luisteren' naar de updates.
		
		int counter = 0;
		for (int i = 0; i < ms; i++) {
			
			if(counter % 1000 == 0) { 
				System.out.println("waiting for: " + counter + "ms");
			}
			this.wait(1);
			counter++;
		}
		System.out.println("Exiting program");
	}
	
	
}
