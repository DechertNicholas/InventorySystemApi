package com.requiemlabs.inventorysystemapi.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    private final InHouseRepository inHouseRepository;
    private final OutsourcedRepository outsourcedRepository;

    @Autowired
    public PartService(InHouseRepository inHouseRepository, OutsourcedRepository outsourcedRepository) {
        this.inHouseRepository = inHouseRepository;
        this.outsourcedRepository = outsourcedRepository;
    }

    public List<InHouse> getInHouse() {
        return inHouseRepository.findAll();
    }

    public List<Outsourced> getOutsourced() {
        return outsourcedRepository.findAll();
    }

    public void addPart(InHouse part) {
        Optional<InHouse> foundPart = inHouseRepository.findInHouseByName(part.getName());
        if (foundPart.isPresent()) {
            throw new IllegalStateException("Part already exists");
        }
        inHouseRepository.save(part);
    }

    public void addPart(Outsourced part) {
        System.out.println(part);
    }


}
