/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author nora
 */
public class Product implements Serializable {

    protected int productid;
    protected String productname;
    protected String description;
    protected int price;
    protected String category;
    protected InputStream image;
    private int quantity;
    protected String base64Image;
    protected float rating;

    public Product(String productname, String description, int price, String category, InputStream image, int quantity) {
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.quantity = quantity;
    }

    public Product(int productid, String productname, String description, int price, String category, int quantity) {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public Product(int productid, String productname, String description, int price, String category, InputStream image, String base64Image) {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.base64Image = base64Image;
    }

    public Product(int productid, String productname, String description, int price, String category, InputStream image, int quantity) {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.quantity = quantity;
    }

    public Product(int productid, String productname, String description, int price, String category, String base64Image, int quantity) {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.base64Image = base64Image;
    }

    public Product(int productid, String productname, String description, int price, String category, String base64Image, int quantity, float rating) {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.base64Image = base64Image;
        this.rating = rating;
    }

    public int getProductid() {
        return productid;
    }

    public String getProductname() {
        return productname;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public InputStream getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
