package com.requiemlabs.inventorysystemapi.part;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PartServiceTest {
    @Mock
    private InHouseRepository inHouseRepository;
    @Mock
    private OutsourcedRepository outsourcedRepository;
    private PartService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PartService(inHouseRepository, outsourcedRepository);
    }

    @Test
    void canGetAllInHouse() {
        // when
        underTest.getAllInHouse();

        // then
        verify(inHouseRepository).findAll();
    }

    @Test
    void canGetAllOutsourced() {
        // when
        underTest.getAllOutsourced();

        // then
        verify(outsourcedRepository).findAll();
    }

    @Test
    void canAddInHousePartWithCorrectArgs() {
        // given
        var newInHouse = new InHouse(
                "Test",
                2f,
                2,
                1,
                3,
                1
        );

        // when
        underTest.addPart(newInHouse);

        // then
        var inHouseArgumentCaptor = ArgumentCaptor.forClass(InHouse.class);

        verify(inHouseRepository).save(inHouseArgumentCaptor.capture());

        var capturedInHouse = inHouseArgumentCaptor.getValue();
        assertThat(capturedInHouse).isEqualTo(newInHouse);
    }

    @Test
    void canAddOutsourcedPartWithCorrectArgs() {
        // given
        var newOutsourced = new Outsourced(
                "Test",
                2f,
                2,
                1,
                3,
                "Test Labs"
        );

        // when
        underTest.addPart(newOutsourced);

        // then
        var outsourcedArgumentCaptor = ArgumentCaptor.forClass(Outsourced.class);

        verify(outsourcedRepository).save(outsourcedArgumentCaptor.capture());

        var capturedInHouse = outsourcedArgumentCaptor.getValue();
        assertThat(capturedInHouse).isEqualTo(newOutsourced);
    }

    @Test
    void willThrowWhenAddingInHouseAlreadyExists() {
        // given
        var newInHouse = new InHouse(
                "Test",
                2f,
                2,
                1,
                3,
                1
        );
        given(inHouseRepository.findInHouseByName(newInHouse.getName()))
                .willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> underTest.addPart(newInHouse))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Part already exists");
        verify(inHouseRepository, never()).save(any());
    }

    // TODO: Add more tests

    @Test
    void testAddPart() {
    }

    @Test
    void deletePart() {
    }

    @Test
    void updateInHouse() {
    }

    @Test
    void updateOutsourced() {
    }
}