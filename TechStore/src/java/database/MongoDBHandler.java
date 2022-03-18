/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author Omar Samir
 */
public class MongoDBHandler {

    public static List<Order>  reviews = new ArrayList<Order>();
    public static MongoClient mongoClient;
    public static MongoCollection<Order> collection;
    public static MongoCursor<Order> cursor;
    //public static Date date = Calendar.getInstance().getTime();
    //public static DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
    //public static String strDate = dateFormat.format(date);

    public static void connectDB() {

// Creating a Mongo client 
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
   
      // Creating Credentials 
      MongoCredential credential; 
      credential = MongoCredential.createCredential("nora", "newDB", 
         "1234".toCharArray()); 
      System.out.println("Connected to the database successfully");  
      
      // Accessing the database 
      MongoDatabase database = mongo.getDatabase("newDB"); 
      System.out.println("Credentials ::"+ credential);
      
      //Creating a collection 
      database.createCollection("sampleCollection"); 
      System.out.println("Collection created successfully"); 

    }

    public static List<Order> retriveOneProduct(BasicDBObject query) {
        cursor = collection.find(query).iterator();
        while (cursor.hasNext()) {
            reviews.add(cursor.next());
        }
        return reviews;
    }

    
}
