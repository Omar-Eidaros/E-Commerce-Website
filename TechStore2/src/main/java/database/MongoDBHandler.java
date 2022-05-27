/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

/**
 *
 * @author Omar Samir
 */
public class MongoDBHandler {

    private static final String dataBaseUrl = "mongodb://uyqf3ppxafmtrb3gjwg5:3zFAqjiHYupsiCrnbQi8@bdwkbvjqqwvfykg-mongodb.services.clever-cloud.com:27017/bdwkbvjqqwvfykg";
    private static final String dataBaseName = "bdwkbvjqqwvfykg";
    public static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void connectDB() {

        // Creating a Mongo client
//        MongoClient mongo = new MongoClient(dataBaseUrl, 27017);
        MongoClient mongoClient = new MongoClient(new MongoClientURI(dataBaseUrl));

        System.out.println("Connected to the database successfully");

        // Accessing the database
        database = mongoClient.getDatabase(dataBaseName);

        for (String name : database.listCollectionNames()) {

            System.out.println(name);
        }

    }

// add order
    public static void addNewOrder(Order order) {
        //Preparing a document
        Document document = new Document();
        document.append("orderdate", order.getOrderDate().toString());
        document.append("userId", order.getUserId());
        document.append("totalprice", order.getTotalprice());
        document.append("productsId", order.getProductIds());
        //Inserting the document into the collection
        database.getCollection("orders").insertOne(document);
    }

// get orders by userid
    public static ArrayList<Order> retriveAllOrders(int userId) {
        ArrayList<Order> order = new ArrayList<Order>();

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("userId", userId);
        MongoCursor<Document> cursor = database.getCollection("orders").find(whereQuery).iterator();

        while (cursor.hasNext()) {
            System.out.println(cursor.next());

        }
        return order;
    }

// add review to database
    public static void addNewReview(Review review) {

//        BasicDBObject whereQuery = new BasicDBObject();
//        whereQuery.put("orderId", review.getOrderId());
//        whereQuery.put("userId", review.getUserId());
//        whereQuery.put("productId", review.getProductId());
        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("orderId", review.getOrderId()));
        obj.add(new BasicDBObject("userId", review.getUserId()));
        obj.add(new BasicDBObject("productId", review.getProductId()));

        andQuery.put("$and", obj);

        MongoCursor<Document> cursor = database.getCollection("reviews").find(andQuery).iterator();

        if (cursor.hasNext()) {
            System.out.println(cursor.next());

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("rating", review.getRating()); // (2)

            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDocument); // (3)

            database.getCollection("reviews").updateOne(andQuery, updateObject); // (4)

        } else {

            //Preparing a document
            Document document = new Document();
            document.append("orderId", review.getOrderId());
            document.append("userId", review.getUserId());
            document.append("productId", review.getProductId());
            document.append("rating", review.getRating());
            //Inserting the document into the collection
            database.getCollection("reviews").insertOne(document);
        }
    }

// calculate review per product
    public static float retriveRatingToOneProduct(int productId) {
        double rating = 0;
        AggregateIterable<org.bson.Document> aggregate = database.getCollection("reviews").aggregate(
                Arrays.asList(
                        (Aggregates.match(new Document("productId", String.valueOf(productId)))),
                        Aggregates.group("productId", new BsonField("averageRating", new BsonDocument("$avg", new BsonString("$rating"))))));
        Document result = aggregate.first();
        if (result != null) {
            rating = result.getDouble("averageRating");
            rating = (rating * 100) / 5;
        }
//        int rating = 0;
//        BasicDBObject whereQuery = new BasicDBObject();
//        whereQuery.put("productId", productId);
//        MongoCursor<Document> cursor = database.getCollection("reviews").find(whereQuery).iterator();
//
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next().getInteger(cursor));
//        }
        return (float) rating;
    }

// calculate review per product
    public static float retriveRatingOrderUserProduct(Review review) {
        double rating = 0;
        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("orderId", review.getOrderId()));
        obj.add(new BasicDBObject("userId", review.getUserId()));
        obj.add(new BasicDBObject("productId", review.getProductId()));

        andQuery.put("$and", obj);

        Document result = database.getCollection("reviews").find(andQuery).first();

        if (result != null) {
            //rating = result.getInteger("rating");
//            System.out.println(result);
            rating = result.getInteger("rating");
//            System.out.println(result.getInteger("rating"));
        }

//        }
        return (float) rating;
    }

//db.createCollection("reviews",{validator:
//{ $jsonSchema: {bsonType: "object",required: [ "orderId","userId","productId","rating" ],
//properties: {
//orderId: {bsonType: "string",description: "must be a string and is required"},
//productId: {bsonType: "string",description: "must be a string and is required"},
//rating: {bsonType: "int",description: "must be a string and is required"},
//userId: {bsonType : "string",description: "must be a string and is required"}
//}
//}}
//})
//db.createCollection("orders",{validator:
//{ $jsonSchema: {bsonType: "object",required: [ "orderdate","userId","productsId","totalprice" ],
//properties: {
//orderdate: {bsonType: "string",description: "must be a string and is required"},
//totalprice: {bsonType: "int",description: "must be a string and is required"},
//productsId: {bsonType: "array",description: "products must be an array of strings",minItems: 1,items: {"bsonType": "string"}},
//userId: {bsonType : "string",description: "must be a string and is required"}
//}
//}}
//})
}
