package com.aaalace.kpomini1.mapper;

import com.aaalace.kpomini1.domain.Animal;
import com.aaalace.kpomini1.domain.animals.Rabbit;
import com.aaalace.kpomini1.domain.animals.Tiger;
import com.aaalace.kpomini1.dto.CreateAnimalRequest;

public class AnimalMapper {
    public static Animal CreateAnimalRequestToAnimal(CreateAnimalRequest createAnimalRequest) {
        return switch (createAnimalRequest.getType().toLowerCase()) {
            case "rabbit" -> new Rabbit(
                    createAnimalRequest.getName(),
                    createAnimalRequest.getFood(),
                    createAnimalRequest.getKindness()
            );
            case "tiger" -> new Tiger(
                    createAnimalRequest.getName(),
                    createAnimalRequest.getFood()
            );
            default -> throw new IllegalArgumentException("Unknown animal type: " + createAnimalRequest.getType());
        };
    }
}
