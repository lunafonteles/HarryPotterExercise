package com.letscode.harryPotterProject.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HouseKeyInfo {

    @JsonProperty("sorting-hat-choice")
    private String key;
    private String name;
}