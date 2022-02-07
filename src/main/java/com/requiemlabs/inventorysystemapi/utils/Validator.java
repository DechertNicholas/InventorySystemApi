package com.requiemlabs.inventorysystemapi.utils;

import com.requiemlabs.inventorysystemapi.part.InHouse;
import com.requiemlabs.inventorysystemapi.part.Outsourced;
import com.requiemlabs.inventorysystemapi.part.Part;

import java.util.Objects;

public class Validator {
    public enum PartType {INHOUSE, OUTSOURCED}
    
    public static boolean validatePartData(Part part, PartType partType) {
        switch (partType) {
            case INHOUSE: {
                if(!validateGeneralPartData(part)) {return false;}
                if(!machineIdAboveZero((InHouse) part)) {return false;}
                return true;
            }
            case OUTSOURCED: {
                if(!validateGeneralPartData(part)) {return false;}
                if(!companyNameNotNullOrEmpty((Outsourced) part)) {return false;}
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean machineIdAboveZero(InHouse part) {
        if (part.getMachineId() > 0) {return true;}
        return false;
    }

    public static boolean companyNameNotNullOrEmpty(Outsourced part) {
        if (!Objects.equals(part.getCompanyName(), "")) {return true;}
        return false;
    }

    public static boolean validateGeneralPartData(Part part) {
        if(nameNotNullOrEmpty(part)
                && priceAboveZero(part)
                && minLowerThanMax(part)
                && inStockBetweenMinMax(part)) {return true;}
        return false;
    }
    
    public static boolean priceAboveZero(Part part) {
        // Nothing is ever free
        if (part.getPrice() > 0) {return true;}
        return false;
    }
    public static boolean nameNotNullOrEmpty(Part part) {
        if (!Objects.equals(part.getName(), "")) {return true;}
        return false;
    }
    
    public static boolean minLowerThanMax(Part part) {
        if (part.getMin() <= part.getMax()) {return true;}
        return false;
    }

    public static boolean inStockBetweenMinMax(Part part) {
        if (part.getInStock() <= part.getMax() && part.getInStock() >= part.getMin()) {return true;}
        return false;
    }
}
