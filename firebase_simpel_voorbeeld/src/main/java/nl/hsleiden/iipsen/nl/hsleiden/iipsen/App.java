package nl.hsleiden.iipsen.nl.hsleiden.iipsen;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    {
    	
    	final String PRIVATEKEY = "/Users/admiraal.f/Java/HSL_iipsen/firebase_simpel_voorbeeld/src/main/java/assets/iipsen-98d8d-firebase-adminsdk-r5w1q-535f334738.json";
    	
        FileInputStream serviceAccount =
				new FileInputStream(PRIVATEKEY);

		FirebaseOptions options = new FirebaseOptions.Builder()
		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		  .setDatabaseUrl("https://iipsen-98d8d.firebaseio.com")
		  .build();
	
		FirebaseApp.initializeApp(options);
		
		Firestore db = FirestoreClient.getFirestore();
		
		
		App app = new App();
		
		// insert/ update
//		app.update(db);
		
//		// get
		app.getQuoteFromFirestore(db);
//		
//		// delete
//		app.deleteFromFirestore(db);
		
    }
    
    
    
    public void deleteFromFirestore(Firestore db) throws InterruptedException, ExecutionException 
    {
    	DocumentReference docRef = db.collection("sampleData").document("my_new_document");
    	ApiFuture<WriteResult> future = docRef.delete();
    	WriteResult result = future.get();
    	
    	System.out.println("Successfully deleted at: " + future.get().getUpdateTime());
    }
    
    
    
    public void getQuoteFromFirestore(Firestore db) throws InterruptedException, ExecutionException {
    	
    	DocumentReference docRef = db.collection("sampleData").document("my_new_document");
    	ApiFuture<DocumentSnapshot> future = docRef.get();
    	DocumentSnapshot document = future.get();
    	
    	if(document.exists()) {
    		String quote = (String) document.get("Gandhi");
    		System.out.println(quote);
    	}else {
    		System.out.println("No such document :(");
    	}
    }
    
    public void update(Firestore db) throws IOException, InterruptedException, ExecutionException {
    	// insert & update
		// Als een document nog niet bestaat wordt het aangemaakt. 
		// Als een document al bestaat wordt het aagepast.
		
    	HashMap<String, String> quote = getSomethingToInsert();
    	
		ApiFuture<WriteResult> future = db.collection("sampleData")
				.document("my_new_document")
				.set(quote);
		
		System.out.println("Successfully updated at: " 
							+ future.get().getUpdateTime());
    }
    
    public HashMap<String, String> getSomethingToInsert() throws IOException
    {
    	HashMap<String, String> quoteHashMap = new HashMap<String, String>();
    	quoteHashMap.put("Gandhi", "Hallo iedereen");
    	
    	return quoteHashMap;
    }
    
    
    
    
}
