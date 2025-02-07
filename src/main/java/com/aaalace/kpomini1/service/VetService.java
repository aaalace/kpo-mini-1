package com.aaalace.kpomini1.service;

import com.aaalace.kpomini1.dto.CreateAnimalRequest;
import org.springframework.stereotype.Service;

@Service
public class VetService {
    public boolean isHealthy(CreateAnimalRequest candidate) {
        return candidate.getFood() < 100;
    }
}
