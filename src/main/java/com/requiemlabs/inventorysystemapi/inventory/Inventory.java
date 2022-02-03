package com.requiemlabs.inventorysystemapi.inventory;

import java.util.List;

public class Inventory {
    public List<Product> Products;
    public List<Part> AllParts;

    public Inventory() {
//        this.Products = new List<Product>();
    }

    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public boolean removeProduct(int partId) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public Product lookupProduct(int productId) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public void addPart(Part part) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public boolean deletePart(Part part) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public Part lookupPart(int partId) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public void updatePart(int partId, Part part) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
