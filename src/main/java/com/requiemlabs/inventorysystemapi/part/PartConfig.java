package com.requiemlabs.inventorysystemapi.part;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * This class initializes starter parts for the api. Parts added here are free to be modified or deleted.
 */
@Configuration
public class PartConfig {

    /**
     * Initializes parts in the database for the api.
     * @param inHouseRepository An inHouseRepository bean.
     * @param outsourcedRepository An outsourcedRepository bean.
     * @return A commandLineRunner loaded with initialization parts.
     */
    @Bean
    CommandLineRunner commandLineRunner(InHouseRepository inHouseRepository, OutsourcedRepository outsourcedRepository) {
        return args -> {
            var inHouse1 = new InHouse(
                    "Wheel",
                    12.11f,
                    15,
                    5,
                    25,
                    1
                );
            var inHouse2 = new InHouse(
                    "Pedal",
                    8.22f,
                    11,
                    5,
                    26,
                    2
            );
            inHouseRepository.saveAll(
                    List.of(inHouse1, inHouse2)
            );

            var outsourced1 = new Outsourced(
                    "Chain",
                    8.33f,
                    12,
                    5,
                    25,
                    "Requiem Labs"
            );
            var outsourced2 = new Outsourced(
                    "Seat",
                    4.55f,
                    8,
                    2,
                    15,
                    "Test Labs"
            );
            outsourcedRepository.saveAll(
                    List.of(outsourced1, outsourced2)
            );
        };
    }
}
