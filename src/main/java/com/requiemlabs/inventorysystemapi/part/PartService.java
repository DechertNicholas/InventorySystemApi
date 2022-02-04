package com.requiemlabs.inventorysystemapi.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    private final InHouseRepository inHouseRepository;

    @Autowired
    public PartService(InHouseRepository inHouseRepository) {
        this.inHouseRepository = inHouseRepository;
    }

    public List<InHouse> getInHouse() {
        return inHouseRepository.findAll();
    }
}
