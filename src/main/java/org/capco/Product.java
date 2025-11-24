package org.capco;

public class Product {
    private final ProductType type;

    public Product(ProductType type) {
        this.type = type;
    }

    public ProductType getType() {
        return type;
    }
}
