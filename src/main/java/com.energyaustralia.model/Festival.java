package com.energyaustralia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Festival {

    private String name;
    public List<Band> bands;

    public Festival() {

    }

    public Festival(String name, List<Band> bands) {
        this.name = name;
        this.bands = bands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Band> getBands() {
        return bands;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "name='" + name + '\'' +
                ", bands=" + bands +
                '}';
    }
}
