/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerHandling;

import com.google.gson.Gson;
import database.UserManager;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.Pair;
import com.google.gson.GsonBuilder; 
import javafx.util.Pair;


/**
 *
 * @author Salma
 */
public class RegisterValidation {


    static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    //Check confirm username requirment
    static int isValidUsername(String username) {
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isDigit(username.charAt(i))
                    && !Character.isLetter(username.charAt(i))
                    && !Character.isWhitespace(username.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    static boolean isValidPhone(String phone) {
        String regex = "^01[0-2]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);

        return m.find() && phone.length() == 11 && phone.matches("[0-9]+");
    }

    public static String checkError(String name, String email, String password, String bdate, String phone, String[] intersets, String job, String street, String city) throws SQLException {
            ErrMsgs errMsg=new ErrMsgs();
            GsonBuilder builder = new GsonBuilder(); 
            Gson gson = builder.create();
            String jsonErr="";
            int num=0;
        if (!"".equals(name)) {
             errMsg.setUserName("");
             num++;
            if (isValidUsername(name) == 0) {
                 errMsg.setUserName("");
                 num++;
            } else {
               errMsg.setUserName("* please enter valid user name with only letters"); 
            }

        } else {
          
           errMsg.setUserName("* you cannot leave name empty");  

        }
        if (!"".equals(email)) {
            errMsg.setEmail("");
            num++;
            if (isValidEmail(email)) {
                   errMsg.setEmail("* please enter valid email"); 
               
            } else {
               
                  errMsg.setEmail("");
                num++;
            }
            if (!UserManager.searchEmail(email)) {
               errMsg.setEmail("");
               num++;
            } else {
               errMsg.setEmail("* Email Already Exists");
               
            }
        } else {
            errMsg.setEmail("* you cannot leave email empty");
            
        }
        if (!"".equals(password)) {
            errMsg.setPassword("");
            num++;
            if (password.length() >= 8) {
                errMsg.setPassword("");
                num++;
            } else {
               errMsg.setPassword("* Password should be more than 8 characters");
              
            }
        } else {
             errMsg.setPassword("* you cannot leave password empty");
           
        }
        if (!"".equals(bdate)) {
            errMsg.setBdate("");
            num++;
        } else {
            errMsg.setBdate("* you cannot leave birth date empty");
            
        }
        if (!"".equals(job)) {
            errMsg.setJob("");
            num++;
        } else {
             errMsg.setJob("* you cannot leave job empty");
           
        }
        if (!(intersets == null)) {
            errMsg.setInterests("");
            num++;
        } else {
            errMsg.setInterests("* you need choose at least one from interests"); 
        }
        if (!"".equals(street)) {
             errMsg.setStreet("");
             num++;
        } else {
            errMsg.setStreet("* you cannot leave Street empty");
        }
        if (!"".equals(city)) {
            errMsg.setCity("");
            num++;
        } else {
            errMsg.setCity("* you cannot leave city empty") ;
        }
        if (!"".equals(phone)) {
            errMsg.setPhone("");
            num++;
            if (isValidPhone(phone)) {
                 errMsg.setPhone("* please enter valid phone number"); 
              
            } else {
                errMsg.setPhone("");
                num++;
            }
            if (!UserManager.searchPhone(phone)) {
                 errMsg.setPhone("");
                 num++;
            } else {
                errMsg.setPhone("* Phone Already Exists");
            }
        } else {
             errMsg.setPhone("* you cannot leave phone empty"); 
        }
        
        jsonErr=gson.toJson(errMsg);
        if(num==15){
        return "";
        
        }
        else
        {
             return jsonErr;
        }
    
    }

}
