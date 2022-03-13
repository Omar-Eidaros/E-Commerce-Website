/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author nora
 */
public class MessageFromDB {

    private String message;
    private Boolean status;

    public MessageFromDB(Boolean status, String message) {
        this.message = message;
        this.status = status;
    }

    public MessageFromDB getMessages() {
        return new MessageFromDB(status, message);
    }

}
