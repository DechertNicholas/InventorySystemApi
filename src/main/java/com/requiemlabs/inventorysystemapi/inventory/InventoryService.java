package com.requiemlabs.inventorysystemapi.inventory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    public List<Part> getParts() {
        return List.of(
                new InHouse(
                        "Test 1",
                        1F,
                        2,
                        1,
                        1,
                        1
                )
        );
    }
}
