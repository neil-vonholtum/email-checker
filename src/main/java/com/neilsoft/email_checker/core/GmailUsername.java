package com.neilsoft.email_checker.core;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class GmailUsername {

    private String gmailUserName;

    //Jersey automatically decodes the application/x-www-form-urlencoded address values. %2B to + etc.
    public GmailUsername(String address){

        address = address.toLowerCase();

        int usernameEndInd = address.lastIndexOf('@');

        if(usernameEndInd < 0)
            throw new WebApplicationException("Address must contain @", Response.Status.BAD_REQUEST);

        if(!address.substring(usernameEndInd).equals("@gmail.com"))
            throw new WebApplicationException("Address must have gmail.com domain", Response.Status.BAD_REQUEST);

        String username = address.substring(0, usernameEndInd);

        int firstPlusInd = username.indexOf('+');

        if(firstPlusInd > -1)
            username = username.substring(0, firstPlusInd);

        username = username.replace(".", "");

        int usernameLength = username.length();

        if(usernameLength < 6 || usernameLength > 30)
            throw new WebApplicationException("Gmail username must be between 6 and 30 characters long", Response.Status.BAD_REQUEST);

        //Additional gmail username restrictions exist. https://support.google.com/mail/answer/9211434?hl=en

        gmailUserName = username;
    }

    public boolean equals(Object o){

        if(o instanceof GmailUsername)
            return gmailUserName.equals(((GmailUsername) o).getGmailUserName());
        else
            return false;
    }

    public String getGmailUserName(){
        return gmailUserName;
    }

    public int hashCode(){
        return gmailUserName.hashCode();
    }
}
