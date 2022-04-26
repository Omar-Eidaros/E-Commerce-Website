/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Omar Samir
 */
public class MongoDBHandler {

    private static String dataBaseUrl = "mongodb://uyqf3ppxafmtrb3gjwg5:l1xjRgKBIGQJipS8lbE4@bdwkbvjqqwvfykg-mongodb.services.clever-cloud.com:27017/bdwkbvjqqwvfykg";
    private static String dataBaseName = "bdwkbvjqqwvfykg";

    public static List<Order> reviews = new ArrayList<Order>();
    public static MongoClient mongoClient;
    public static MongoCollection<Order> collection;
    public static MongoCursor<Order> cursor;

    public static void connectDB() {

        // Creating a Mongo client 
//        MongoClient mongo = new MongoClient(dataBaseUrl, 27017);
        MongoClient mongoClient = new MongoClient(new MongoClientURI(dataBaseUrl));

        System.out.println("Connected to the database successfully");

        // Accessing the database 
        MongoDatabase database = mongoClient.getDatabase(dataBaseName);

        //Creating a collection 
//        database.createCollection("sampleCollection");
        for (String name : database.listCollectionNames()) {

            System.out.println(name);
        }
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
