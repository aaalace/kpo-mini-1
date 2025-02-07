package com.aaalace.kpomini1.repository;

import com.aaalace.kpomini1.domain.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {
    static final List<Animal> animals = new ArrayList<>();

    public List<Animal> findAll() {
        return animals;
    }

    public void save(Animal animal) {
        animals.add(animal);
    }
}
