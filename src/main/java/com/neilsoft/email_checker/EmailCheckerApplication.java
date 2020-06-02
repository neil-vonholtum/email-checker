package com.neilsoft.email_checker;

import com.neilsoft.email_checker.resources.EmailCheckerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class EmailCheckerApplication extends Application<EmailCheckerConfiguration> {

    public static void main(String[] args) throws Exception{
        new EmailCheckerApplication().run(args);
    }

    @Override
    public String getName(){
        return "email-checker";
    }

    @Override
    public void run(EmailCheckerConfiguration configuration, Environment environment){
        final EmailCheckerResource resource = new EmailCheckerResource();
        environment.jersey().register(resource);
    }
}
