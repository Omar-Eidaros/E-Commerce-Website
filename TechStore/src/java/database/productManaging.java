/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Base64;
import java.util.Vector;

/**
 *
 * @author nora
 */
public class productManaging {
    
    private Connection conn = DataHandling.getConnection();

    // add product 
    public MessageFromDB addProduct(Product product) throws SQLException {
        try {
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (productname , description , price , category, image, quantity)VALUES (? , ? , ? , ?, ?, ?)");
            stmt.setString(1, product.getProductname());
            stmt.setString(2, product.getDescription());
            stmt.setInt(3, product.getPrice());
            stmt.setObject(4, product.getCategory(), Types.OTHER);
            stmt.setBinaryStream(5, product.getImage());
            stmt.setInt(6, product.getQuantity());
            
            int isInsert = stmt.executeUpdate();
            if (isInsert == 1) {
                return new MessageFromDB(true, "Done add product");
            } else {
                return new MessageFromDB(false, "please try again");
            }
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            
            if (e.getSQLState().equals("23505")) {
                //String msg = e.getMessage();
                // String whichError = msg.substring(msg.indexOf("(") + 1, msg.indexOf(")"));
                //System.out.println(" :  " + whichError);
                return new MessageFromDB(false, "please try again");
            } else {
                return new MessageFromDB(false, "please try again");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageFromDB(false, "please try again");
        }
    }

    // display products
    public Vector<Product> getALLProduct() throws SQLException {
        Vector<Product> products = new Vector<Product>();
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement("select * from products");
            
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                
                InputStream inputStream = res.getBinaryStream("image");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                
                products.add(new Product(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), base64Image, res.getInt(7)));
            }
            
        } catch (SQLException e) {
            //return new MessageFromDB(false, "please try again");
            System.err.println(e);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);

            //return new MessageFromDB(false, "please try again");
        }
        return products;
    }

    // edit prodoct 
    // delete product 
    public MessageFromDB deleteProduct(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("delete from products where productid = ?");
        stmt.setInt(1, id);
        int res = stmt.executeUpdate();
        if (res == 1) {
            return new MessageFromDB(true, "product id : " + id);
        } else {
            return new MessageFromDB(false, "please try again");
        }
    }

    // search product 
    public Vector<Product> searchProduct(int priceFrom, int priceTo, String category) throws SQLException {
        Vector<Product> products = new Vector<Product>();

        try {
            PreparedStatement stmt;
            
            if (!category.equalsIgnoreCase("all") && priceFrom != -1 && priceTo != -1) {
                stmt = conn.prepareStatement("select * from products where (price between ? and ?) and category = ? ");
//                stmt.setInt(1, priceFrom);
//                stmt.setInt(2, priceTo);
                stmt.setObject(1, priceFrom, Types.OTHER);
                stmt.setObject(2, priceTo, Types.OTHER);
                
                stmt.setObject(3, category, Types.OTHER);                
            } else if (!category.equalsIgnoreCase("all")) {
                stmt = conn.prepareStatement("select * from products where category = ? ");
                stmt.setObject(1, category, Types.OTHER);
                
            } else if (priceFrom != -1 && priceTo != -1) {
                stmt = conn.prepareStatement("select * from products where price between ? and ? ");
                stmt.setObject(1, priceFrom, Types.OTHER);
                stmt.setObject(2, priceTo, Types.OTHER);
            } else {
                stmt = conn.prepareStatement("select * from products");

            }
            
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                
                InputStream inputStream = res.getBinaryStream("image");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                
                products.add(new Product(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), base64Image, res.getInt(7)));
            }
            
        } catch (SQLException e) {
            //return new MessageFromDB(false, "please try again");
            System.err.println(e);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);

            //return new MessageFromDB(false, "please try again");
        }
        return products;
        
    }
}
