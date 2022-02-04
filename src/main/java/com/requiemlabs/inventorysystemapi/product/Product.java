package com.requiemlabs.inventorysystemapi.product;

import com.requiemlabs.inventorysystemapi.part.Part;

import java.util.List;

public class Product {
    public List<Part> AssociatedParts;
    public int ProductId;
    public String Name;
    public float Price;
    public int InStock;
    public int Min;
    public int Max;

    public void addAssociatedPart(Part part) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public boolean removeAssociatedPart(int partId) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public Part lookupAssociatedPart(int partId) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
