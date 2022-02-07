package com.requiemlabs.inventorysystemapi.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A controller specifically for InHouse and Outsourced parts.
 */
@RestController
@RequestMapping("api/v1/part")
public class PartController {

    // region Private variables
    private final PartService partService;
    // endregion

    // region Constructors
    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }
    // endregion

    // region GetMappings
    /**
     * Requests all InHouse and Outsourced parts from the service, then returns them.
     * @return A list of all InHouse and Outsourced parts.
     */
    @GetMapping
    public List<Part> GetAllParts() {
        var returnList = new ArrayList<Part>();
        returnList.addAll(partService.getAllOutsourced());
        returnList.addAll(partService.getAllInHouse());
        Collections.sort(returnList);
        return returnList;
    }

    /**
     * Requests all InHouse parts from the service.
     * @return A list of all InHouse parts.
     */
    @GetMapping("/InHouse")
    public List<InHouse> GetInHouseParts() {
        return partService.getAllInHouse();
    }

    /**
     * Requests all Outsourced parts from the service.
     * @return A list of all Outsourced parts.
     */
    @GetMapping("/Outsourced")
    public List<Outsourced> GetOutsourcedParts() { return partService.getAllOutsourced(); }
    // endregion

    // region PostMappings

    /**
     * Adds a new InHouse part.
     * @param part The part to add. PartId will be automatically generated, the rest must be in json format in the
     *             request body.
     */
    @PostMapping("/InHouse")
    public void addPart(@RequestBody InHouse part) { partService.addPart(part); }

    /**
     * Adds a new Outsourced part.
     * @param part The part to add. PartId will be automatically generated, the rest must be in json format in the
     *             request body.
     */
    @PostMapping("/Outsourced")
    public void addPart(@RequestBody Outsourced part) { partService.addPart(part); }
    // endregion

    // region DeleteMappings

    /**
     * Deletes a part with the specified PartId.
     * @param id The id of the part to be deleted.
     */
    @DeleteMapping(path = "/{partId}")
    public void deletePart(@PathVariable("partId") long id) {
        // InHouse and Outsourced share the same generation sequence, so id will be unique among both repositories
        partService.deletePart(id);
    }
    // endregion

    // region PutMappings
    /**
     * Updates an InHouse part with the specified id, using the information in the url.
     * @param id The id of the part to be updated.
     * @param name The new name of the part.
     * @param price The new price of the part.
     * @param inStock The new InStock amount of the part.
     * @param min The new Min value of the part.
     * @param max The new Max value of the part.
     * @param machineId The new MachineId of the part.
     */
    @PutMapping(path = "/InHouse/{partId}")
    public void updateInHouse(
            @PathVariable("partId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "-1f") Float price,
            @RequestParam(required = false, defaultValue = "-1") Integer inStock,
            @RequestParam(required = false, defaultValue = "-1") Integer min,
            @RequestParam(required = false, defaultValue = "-1") Integer max,
            @RequestParam(required = false, defaultValue = "-1") Integer machineId) {
        System.out.println(String.format("ID: %d", id));
        partService.updateInHouse(id, name, price, inStock, min, max, machineId);
    }

    /**
     * Updates an Outsourced part with the specified id, using the information in the url.
     * @param id The id of the part to be updated.
     * @param name The new name of the part.
     * @param price The new price of the part.
     * @param inStock The new InStock amount of the part.
     * @param min The new Min value of the part.
     * @param max The new Max value of the part.
     * @param companyName The new CompanyName of the part.
     */
    @PutMapping(path = "/Outsourced/{partId}")
    public void updateOutsourced(
            // Use object data types to allow null values, then default to negative values.
            // Negative values will not get past the service layer, but if they do, will not get past the
            // Part's internal setters.
            @PathVariable("partId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "-1f") Float price,
            @RequestParam(required = false, defaultValue = "-1") Integer inStock,
            @RequestParam(required = false, defaultValue = "-1") Integer min,
            @RequestParam(required = false, defaultValue = "-1") Integer max,
            @RequestParam(required = false) String companyName) {
        partService.updateOutsourced(id, name, price, inStock, min, max, companyName);
    }
    // endregion
}
