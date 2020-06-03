package com.neilsoft.email_checker.core;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class GmailUsername {

    private String gmailUserName;

    //Jersey automatically decodes the application/x-www-form-urlencoded address values. %2B to + etc.
    public GmailUsername(String address){

        if(!(address = address.toLowerCase()).endsWith("@gmail.com"))
            throw new WebApplicationException("Address must have gmail.com domain", Response.Status.BAD_REQUEST);

        int firstPlusInd = address.indexOf('+'), usernameLength;

        gmailUserName = address.substring(0, firstPlusInd > -1 ? firstPlusInd : address.lastIndexOf('@')).replace(".", "");

        if((usernameLength = gmailUserName.length()) < 6 || usernameLength > 30)
            throw new WebApplicationException("Gmail username must be between 6 and 30 characters long", Response.Status.BAD_REQUEST);

        //Additional gmail username restrictions exist. https://support.google.com/mail/answer/9211434?hl=en
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
