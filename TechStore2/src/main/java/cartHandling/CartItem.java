/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartHandling;

import database.Product;

/**
 *
 * @author Salma
 */
public class CartItem extends Product {

    public CartItem(Product p, int q) {
        super(p.getProductid(), p.getProductname(), p.getDescription(), p.getPrice(), p.getCategory(), p.getBase64Image(), q);

    }

}
