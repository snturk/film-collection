package com.example.filmList.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class performerAddForm {

    @NotEmpty
    @Size(min = 1, max = 40)
    private String performerName;

    @NotEmpty
    @Size(min = 1, max = 40)
    private String performerRole;

    //GETTERS

    public String getPerformerName() {
        return performerName;
    }

    public String getPerformerRole() {
        return performerRole;
    }

    //SETTERS

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public void setPerformerRole(String performerRole) {
        this.performerRole = performerRole;
    }
}
