/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerHandling;

/**
 *
 * @author Salma
 */
public class ErrMsgs {
    private String email;
    private String phone;
    private String city;
    private String street;
    private String job;
    private String interests;
    private String bdate;
    private String password;
    private String userName;

    public ErrMsgs() {
    }
    

    public ErrMsgs(String email, String phone, String city, String street, String job, String interests, String bdate, String password, String userName) {
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.job = job;
        this.interests = interests;
        this.bdate = bdate;
        this.password = password;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
