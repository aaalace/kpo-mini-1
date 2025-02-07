package com.aaalace.kpomini1.service;

import com.aaalace.kpomini1.domain.Animal;
import com.aaalace.kpomini1.domain.Herbivore;
import com.aaalace.kpomini1.dto.CreateAnimalRequest;
import com.aaalace.kpomini1.mapper.AnimalMapper;
import com.aaalace.kpomini1.repository.AnimalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ZooService {
    private final VetService vetService;
    private final AnimalRepository animalRepository;

    public ZooService(VetService vetService, AnimalRepository animalRepository) {
        this.vetService = vetService;
        this.animalRepository = animalRepository;
    }

    public Animal postAnimal(CreateAnimalRequest createAnimalRequest) throws Exception {
        try {
            final boolean isHealthy = this.vetService.isHealthy(createAnimalRequest);
            if (!isHealthy) {
                throw new IllegalArgumentException("Animal is not healthy");
            }

            final Animal animal = AnimalMapper.CreateAnimalRequestToAnimal(createAnimalRequest);
            this.animalRepository.save(animal);

            return animal;
        } catch (IllegalArgumentException e) {
            log.error("Error in validation new animal: {}", e.getMessage());
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            log.error("Error post new animal: {}", e.getMessage());
            throw new Exception("Internal server error");
        }
    }

    public List<Animal> getAllAnimals() throws Exception {
        try {
            return this.animalRepository.findAll();
        } catch (Exception e) {
            log.error("Error get all animals: {}", e.getMessage());
            throw new Exception("Internal server error");
        }
    }

    public Integer getTotalFood() throws Exception {
        try {
            final List<Animal> animals = this.animalRepository.findAll();
            return animals.stream().mapToInt(Animal::getFoodAmount).sum();
        } catch (Exception e) {
            log.error("Error count total food: {}", e.getMessage());
            throw new Exception("Internal server error");
        }
    }

    public List<Animal> getContactAnimals() throws Exception {
        try {
            final List<Animal> animals = this.animalRepository.findAll();
            return animals.stream()
                    .filter(animal -> animal instanceof Herbivore)
                    .map(animal -> (Herbivore) animal)
                    .filter(Herbivore::isFriendly)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error get contact animals: {}", e.getMessage());
            throw new Exception("Internal server error");
        }
    }
}
