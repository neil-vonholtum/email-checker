package com.neilsoft.email_checker.resources;

import com.neilsoft.email_checker.api.Representation;
import com.neilsoft.email_checker.core.GmailUsername;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/email-checker")
@Produces(MediaType.APPLICATION_JSON)
public class EmailCheckerResource {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Representation postEndpoint(@FormParam("address") Set<GmailUsername> gmailUsernames){
        return new Representation(gmailUsernames.size());
    }
}
