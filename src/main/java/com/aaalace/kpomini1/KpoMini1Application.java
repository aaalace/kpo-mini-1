package com.aaalace.kpomini1;

import com.aaalace.kpomini1.common.enums.Command;
import com.aaalace.kpomini1.controller.ZooController;
import com.aaalace.kpomini1.dto.CreateAnimalRequest;
import com.aaalace.kpomini1.util.AnimalTypeUtil;
import com.aaalace.kpomini1.util.CommandUtil;
import com.aaalace.kpomini1.util.DateTimeUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class KpoMini1Application implements CommandLineRunner {
    private final String sessionId;
    private final ZooController zooController;

    public KpoMini1Application(ZooController zooController) {
        this.sessionId = UUID.randomUUID().toString();
        this.zooController = zooController;
    }

    public static void main(String[] args) {
        SpringApplication.run(KpoMini1Application.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Start zoo management session - {}", sessionId);
        this.poll();
        log.info("Finish zoo management session - {}", sessionId);
    }

    // simulates sending "requests" that will be handled in "controller"
    private void poll() {
        System.out.printf("Your session started at %s\n", DateTimeUtil.getCurrentTimestamp());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            CommandUtil.outCommands();
            try {
                Command command = CommandUtil.getCommandById(reader.readLine());
                switch (command) {
                    case POST_ANIMAL -> this.callHandlePostAnimal();
                    case GET_ALL_ANIMALS -> this.zooController.handleGetAllAnimals();
                    case GET_TOTAL_FOOD -> this.zooController.handleGetTotalFood();
                    case GET_ANIMALS_BY_CONTACT_FILTER -> this.zooController.handleGetContactAnimals();

                    case EXIT_ZOO -> { return; }
                }
            } catch (Exception e) {
                log.error("Error processing request: {}", e.getMessage());
                System.out.printf(RED + "Error processing request: %s\n" + RESET, e.getMessage());
            }
        }
    }

    private void callHandlePostAnimal() throws Exception {
        CreateAnimalRequest candidate = new CreateAnimalRequest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter animal name: ");
            candidate.setName(reader.readLine());

            System.out.print("Enter animal type: [tiger, rabbit] ");
            final String type = reader.readLine();
            if (!AnimalTypeUtil.containsAnimalType(type)) {
                throw new IllegalArgumentException("Invalid animal type");
            }
            candidate.setType(type);

            if (AnimalTypeUtil.containsHerbivoreAnimalType(type)) {
                System.out.print("Enter animal kindness: ");
                candidate.setKindness(Double.parseDouble(reader.readLine()));
            }

            System.out.print("Enter animal food per day: ");
            candidate.setFood(Integer.parseInt(reader.readLine()));

        } catch (IOException e) {
            log.error("Error reading animal data: {}", e.getMessage());
            throw new Exception("Internal server error");
        } catch (IllegalArgumentException e) {
            log.error("Error in provided animal data: {}", e.getMessage());
            throw new Exception(e.getMessage());
        }

        this.zooController.handlePostAnimal(candidate);
    }

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
}
