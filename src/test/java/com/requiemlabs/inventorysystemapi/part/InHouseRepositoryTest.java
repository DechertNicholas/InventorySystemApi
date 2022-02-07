package com.requiemlabs.inventorysystemapi.part;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InHouseRepositoryTest {
    @Autowired
    private InHouseRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindInHouseByNameIfExists() {
        // given
        var name = "Test Part";
        var newInHouse = new InHouse (
                name,
                2f,
                2,
                1,
                3,
                1
        );
        underTest.save(newInHouse);

        // when
        var expected = underTest.findInHouseByName(name);

        // then
        assertThat(expected).isEqualTo(true);
    }

    @Test
    void itShouldNotFindInHouseByNameIfDoesNotExist() {
        // given
        var name = "Test Part";

        // when
        var expected = underTest.findInHouseByName(name);

        // then
        assertThat(expected).isEqualTo(false);
    }
}