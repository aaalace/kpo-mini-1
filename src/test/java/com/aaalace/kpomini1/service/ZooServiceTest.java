package com.aaalace.kpomini1.service;

import com.aaalace.kpomini1.domain.Animal;
import com.aaalace.kpomini1.dto.CreateAnimalRequest;
import com.aaalace.kpomini1.repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ZooServiceTest {
    @InjectMocks
    private ZooService zooService;

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private VetService vetService;

    @Test
    void testPostAnimalHealthy() throws Exception {
        CreateAnimalRequest request = new CreateAnimalRequest();
        request.setFood(10);

        when(vetService.isHealthy(request)).thenReturn(true);

        Animal result = zooService.postAnimal(request);
        assertNotNull(result);
        assertEquals(10, result.getFoodAmount());
        verify(animalRepository, times(1)).save(any(Animal.class));
    }

    @Test
    void testPostAnimalUnhealthy() throws Exception {
        CreateAnimalRequest request = new CreateAnimalRequest();
        request.setFood(101);

        when(vetService.isHealthy(request)).thenReturn(true);

        Animal result = zooService.postAnimal(request);
        assertNotNull(result);
        assertEquals(101, result.getFoodAmount());
        verify(animalRepository, times(1)).save(any(Animal.class));
    }
}