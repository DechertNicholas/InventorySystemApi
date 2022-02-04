package com.requiemlabs.inventorysystemapi.part;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PartConfig {

    @Bean
    CommandLineRunner commandLineRunner(InHouseRepository inHouseRepository, OutsourcedRepository outsourcedRepository) {
        return args -> {
            var inHouse1 = new InHouse(
                    "Test 1",
                    1F,
                    2,
                    1,
                    1,
                    1
                );
            var inHouse2 = new InHouse(
                    "Test 2",
                    2F,
                    2,
                    1,
                    1,
                    2
            );
            inHouseRepository.saveAll(
                    List.of(inHouse1, inHouse2)
            );

            var outsourced1 = new Outsourced(
                    "Test 1",
                    1F,
                    2,
                    1,
                    1,
                    "Requiem Labs"
            );
            var outsourced2 = new Outsourced(
                    "Test 2",
                    2F,
                    2,
                    1,
                    1,
                    "Test Labs"
            );
            outsourcedRepository.saveAll(
                    List.of(outsourced1, outsourced2)
            );
        };
    }
}
