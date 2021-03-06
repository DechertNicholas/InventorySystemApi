package com.requiemlabs.inventorysystemapi.part;

import com.requiemlabs.inventorysystemapi.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * A service specifically for Parts.
 */
@Service
public class PartService {

    // region Private variables
    private final InHouseRepository inHouseRepository;
    private final OutsourcedRepository outsourcedRepository;
    // endregion

    // region Constructors
    @Autowired
    public PartService(InHouseRepository inHouseRepository, OutsourcedRepository outsourcedRepository) {
        this.inHouseRepository = inHouseRepository;
        this.outsourcedRepository = outsourcedRepository;
    }
    // endregion

    // region GetRequests
    /**
     * Returns a list of all InHouse parts from the repository.
     * @return A list of InHouse parts.
     */
    public List<InHouse> getAllInHouse() {
        return inHouseRepository.findAll();
    }

    /**
     * Returns a list of all Outsourced parts from the repository.
     * @return A list of Outsourced parts.
     */
    public List<Outsourced> getAllOutsourced() {
        return outsourcedRepository.findAll();
    }
    // endregion

    // region AddRequests
    /**
     * Adds a new InHouse part to the repository if a part with that name does not already exist.
     * @param part The InHouse part to add.
     * @throws IllegalStateException If the part already exists or Min Max InStock values are incorrect.
     */
    public void addPart(InHouse part) throws IllegalStateException {
        // Check if an InHouse with that name exists already
        var partFound = inHouseRepository.findInHouseByName(part.getName());
        if (partFound) {
            throw new IllegalStateException("Part already exists");
        }
        // Validate part data
        if (Validator.validatePartData(part, Validator.PartType.INHOUSE)) {
            inHouseRepository.save(part);
        } else {
            throw new IllegalStateException("Failed to validate part data. Check your part information.");
        }
    }

    /**
     * Adds a new Outsourced part to the repository if a part with that name does not already exist.
     * @param part The Outsourced part to add.
     * @throws IllegalStateException If the part already exists or Min Max InStock values are incorrect.
     */
    public void addPart(Outsourced part) throws IllegalStateException {
        // Check if an Outsourced part with that name already exists
        var partFound = outsourcedRepository.findOutsourcedByName(part.getName());
        if (partFound) {
            throw new IllegalStateException("Part already exists");
        }
        // Validate part data
        if (Validator.validatePartData(part, Validator.PartType.OUTSOURCED)) {
            outsourcedRepository.save(part);
        } else {
            throw new IllegalStateException("Failed to validate part data. Check your part information.");
        }
    }
    // endregion

    // region DeleteRequests
    /**
     * Deletes a part from the repository. Can be InHouse or Outsourced.
     * @param id The id of the InHouse or Outsourced part to delete
     */
    public void deletePart(long id) throws IllegalStateException {
        // Check both repositories for the given part id, and throw if that id is not found.
        Optional<InHouse> foundInHouse = inHouseRepository.findById(id);
        if (foundInHouse.isPresent()) {
            inHouseRepository.deleteById(id);
            return;
        }
        Optional<Outsourced> foundOutsourced = outsourcedRepository.findById(id);
        if (foundOutsourced.isPresent()) {
            outsourcedRepository.deleteById(id);
            return;
        }
        throw new IllegalStateException(String.format("Part with id %d not found!", id));
    }
    // endregion

    // region UpdateRequests
    /**
     * Updates an InHouse part with the given id to the given information.
     * @param id The PartId of the part to be updated.
     * @param name The new Name of the part.
     * @param price The new Price of the part
     * @param inStock The new InStock amount of the part.
     * @param min The new Min value of the part.
     * @param max The new Max value of the part.
     * @param machineId The new MachineId of the part.
     */
    @Transactional
    public void updateInHouse(Long id, String name, float price, int inStock, int min, int max, int machineId)
            throws IllegalStateException {

        var part = inHouseRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("Cannot find part with id %d", id)
        ));

        // Provided a part is found above, validate the rest of the input for the part


        if(name != null) {
            // Only query the DB if name has a value
            var partFound = inHouseRepository.findInHouseByName(name);
            if(partFound) {
                throw new IllegalStateException(String.format("Part with name %s already exists", name));
            }
            part.setName(name);
        }
        if (price > 0.0f) {part.setPrice(price);}
        if (inStock >= 0) {part.setInStock(inStock);}
        if (min >= 0) {part.setMin(min);}
        if (max >= 0) {part.setMax(max);}
        if (machineId >= 0) {part.setMachineId(machineId);}
    }

    /**
     * Updates an Outsourced part with the given id to the given information.
     * @param id The PartId of the part to be updated.
     * @param name The new Name of the part.
     * @param price The new Price of the part
     * @param inStock The new InStock amount of the part.
     * @param min The new Min value of the part.
     * @param max The new Max value of the part.
     * @param companyName The new CompanyName of the part.
     */
    @Transactional
    public void updateOutsourced(Long id, String name, float price, int inStock, int min, int max, String companyName)
            throws IllegalStateException {

        var part = outsourcedRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("Cannot find part with id %d", id)
        ));
        if(name != null) {
            // Only query the DB if name has a value
            var partFound = outsourcedRepository.findOutsourcedByName(name);
            if(partFound) {
                throw new IllegalStateException(String.format("Part with name %s already exists", name));
            }
            part.setName(name);
        }
        if (price > 0.0f) {part.setPrice(price);}
        if (inStock >= 0) {part.setInStock(inStock);}
        if (min >= 0) {part.setMin(min);}
        if (max >= 0) {part.setMax(max);}
        if (companyName != null) {part.setCompanyName(companyName);}
    }
    // endregion
}
