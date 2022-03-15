/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import static database.MongoDBHandler.collection;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Omar Samir
 */
public class Main {
    
      public static void main(String[] args) {
      
      MongoDBHandler.connectDB();
      
      BasicDBObject qury = new BasicDBObject("productId","10");
      MongoDBHandler.retriveOneProduct(qury);
}   
}
