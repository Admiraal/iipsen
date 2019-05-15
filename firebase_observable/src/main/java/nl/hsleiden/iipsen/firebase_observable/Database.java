package nl.hsleiden.iipsen.firebase_observable;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class Database {

	private static final String privateKeyLocation = "/Users/admiraal.f/Java/HSL_iipsen/firebase_observable/assets/iipsen-98d8d-firebase-adminsdk-r5w1q-535f334738.json";
	private static final String databaseUrl = "https://iipsen-98d8d.firebaseio.com";
	private Firestore db;
	
	
	public Database() {
		
		try {
			FileInputStream serviceAccount =
					new FileInputStream(privateKeyLocation);
	
	        
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://iipsen-98d8d.firebaseio.com")
			  .build();
		
			FirebaseApp.initializeApp(options);
			this.db = FirestoreClient.getFirestore();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Firestore getFirestoreDatabase() {
		return this.db;
	}

}
