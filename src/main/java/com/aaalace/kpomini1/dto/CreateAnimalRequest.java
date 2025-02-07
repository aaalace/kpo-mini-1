package com.aaalace.kpomini1.dto;

import lombok.Data;

@Data
public class CreateAnimalRequest {
    private String name;

    private String type;

    private Integer food;

    private Double kindness;
}
