package com.neilsoft.email_checker;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailCheckerConfiguration extends Configuration {

    @JsonProperty
    private String configVal;
}
