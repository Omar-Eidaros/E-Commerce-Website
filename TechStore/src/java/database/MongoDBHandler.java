/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Projections;
import com.mongodb.MongoClient;
import java.text.DateFormat;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

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

        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase db = mongoClient.getDatabase("TechStore").withCodecRegistry(pojoCodecRegistry);
        collection = db.getCollection("Order", Order.class);
    }

    public static List<Order> retriveOneProduct(BasicDBObject query) {
        cursor = collection.find(query).iterator();
        while (cursor.hasNext()) {
            reviews.add(cursor.next());
        }
        return reviews;
    }

    
}
