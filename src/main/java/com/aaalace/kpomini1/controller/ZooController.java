package com.aaalace.kpomini1.controller;

import com.aaalace.kpomini1.domain.Animal;
import com.aaalace.kpomini1.dto.CreateAnimalRequest;
import com.aaalace.kpomini1.service.ZooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
// parody on REST controller
public class ZooController {
    private final ZooService zooService;

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    public void handlePostAnimal(CreateAnimalRequest createAnimalRequest) throws Exception {
        final Animal animal = this.zooService.postAnimal(createAnimalRequest);
        System.out.printf("Animal:\n%s", this.outAnimal(animal));
    }

    public void handleGetAllAnimals() throws Exception {
        final List<Animal> animals = this.zooService.getAllAnimals();
        System.out.printf("Animals:\n%s", this.outAnimals(animals));
    }

    public void handleGetTotalFood() throws Exception {
        final Integer totalFood = this.zooService.getTotalFood();
        System.out.printf("Total food:\n%s\n", totalFood);
    }

    public void handleGetContactAnimals() throws Exception {
        final List<Animal> animals = this.zooService.getContactAnimals();
        System.out.printf("Animals:\n%s", this.outAnimals(animals));
    }

    private String outAnimal(Animal animal) {
        return animal.toString() + "\n";
    }

    public String outAnimals(List<Animal> animals) {
        StringBuilder result = new StringBuilder();
        for (Animal animal : animals) {
            result.append(outAnimal(animal));
        }
        return result.toString();
    }
}