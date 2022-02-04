package com.requiemlabs.inventorysystemapi.part;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PartConfig {

    @Bean
    CommandLineRunner commandLineRunner(PartRepository partRepository) {
        return args -> {
            var part1 = new InHouse(
                    "Test 1",
                    1F,
                    2,
                    1,
                    1,
                    1
                );
            var part2 = new InHouse(
                    "Test 2",
                    2F,
                    2,
                    1,
                    1,
                    2
            );

            partRepository.saveAll(
                    List.of(part1, part2)
            );
        };
    }
}
