<%-- 
    Document   : newjsp
    Created on : Mar 19, 2022, 12:06:00 PM
    Author     : Mustafa Raed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
Account SID = AC5136320a729813730fe3a47285a31886
Auth Token = d81d293af4a29be85cc469f4041edfae
My Twilio phone number = +16073035175

curl -X POST https://api.twilio.com/2010-04-01/Accounts/AC5136320a729813730fe3a47285a31886/Messages.json \
                --data-urlencode "Body=Hello from Twilio" \
                --data-urlencode "From=+16073035175" \
                --data-urlencode "To=+201100081688" \
                -u AC5136320a729813730fe3a47285a31886:d81d293af4a29be85cc469f4041edfae
                
              
// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+15558675310"),
                new com.twilio.type.PhoneNumber("+15017122661"),
                "This is the ship that made the Kessel Run in fourteen parsecs?")
            .create();

        System.out.println(message.getSid());
    }
}