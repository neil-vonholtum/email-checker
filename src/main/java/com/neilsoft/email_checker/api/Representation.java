package com.neilsoft.email_checker.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Representation {

    @JsonProperty
    private int unique;

    public Representation(int unique){
        this.unique = unique;
    }
}
