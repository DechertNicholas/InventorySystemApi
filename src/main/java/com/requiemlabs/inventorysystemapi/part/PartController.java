package com.requiemlabs.inventorysystemapi.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/part")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping
    public List<Part> GetAllParts() {
        var returnList = new ArrayList<Part>();
        returnList.addAll(partService.getOutsourced());
        returnList.addAll(partService.getInHouse());
        Collections.sort(returnList);
        return returnList;
    }

    @GetMapping("/InHouse")
    public List<InHouse> GetInHouseParts() {
        return partService.getInHouse();
    }

    @GetMapping("/Outsourced")
    public List<Outsourced> GetOutsourcedParts() { return partService.getOutsourced(); }

    @PostMapping("/InHouse")
    public void addPart(@RequestBody InHouse part) { partService.addPart(part); }

    @PostMapping("/Outsourced")
    public void addPart(@RequestBody Outsourced part) { partService.addPart(part); }

    @DeleteMapping(path = "/InHouse/{partId}")
    public void deletePart(@PathVariable("partId") Long id) {

    }
}
