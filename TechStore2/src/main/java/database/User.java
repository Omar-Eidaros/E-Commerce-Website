/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Date;

/**
 *
 * @author Omar Samir
 */
public class User {

    private int UserId;
    private String Name;
    private String Email;
    private String Password;
    private Date BirthDate;

    public User(int UserId, String Name, String Email, String Password, String Phone, int CreditLimit) {
        this.UserId = UserId;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Phone = Phone;
        this.CreditLimit = CreditLimit;
    }

    private String Phone;
    private String city;
    private String street;
    private String[] Intersets;
    private String Job;
    private int CreditLimit;

    public User() {
        this.UserId = 0;
        this.Name = null;
        this.Email = null;
        this.Password = null;
        this.BirthDate = null;
        this.Phone = null;
        this.city = null;
        this.street = null;
        this.Intersets = null;
        this.Job = null;
        this.CreditLimit = 0;

    }

    public User(String Name, String Email, String Password, Date BirthDate, String Phone, String city, String street, String[] Intersets, String Job) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.BirthDate = BirthDate;
        this.Phone = Phone;
        this.city = city;
        this.street = street;
        this.Intersets = Intersets;
        this.Job = Job;
    }

    public User(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }

    User(String name, String email, String phone, String city, String street) {
        this.Name = name;
        this.Email = email;
        this.Phone = phone;
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String[] getIntersets() {
        return Intersets;
    }

    public void setIntersets(String[] Intersets) {
        this.Intersets = Intersets;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public int getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(int CreditLimit) {
        this.CreditLimit = CreditLimit;
    }

}
