package org.capco;// Cart.java

import java.util.EnumMap;
import java.util.Map;

public class Cart {
    private final Client client;
    private final Map<ProductType, Integer> products;
    private final PricingStrategy pricingStrategy;

    public Cart(Client client, PricingStrategy pricingStrategy) {
        if (client == null) {
            throw new NullPointerException("Client cannot be null");
        }
        if (pricingStrategy == null) {
            throw new NullPointerException("PricingStrategy cannot be null");
        }
        this.client = client;
        this.pricingStrategy = pricingStrategy;
        this.products = new EnumMap<>(ProductType.class);
        for (ProductType type : ProductType.values()) {
            products.put(type, 0); // initialize quantities to 0
        }
    }

    public void addProduct(ProductType type, int quantity) {
        if (type == null) {
            throw new NullPointerException("Product type cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        products.merge(type, quantity, Integer::sum);
    }

    public void removeProduct(ProductType type, int quantity) {
        if (type == null) {
            throw new NullPointerException("Product type cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        int existing = products.getOrDefault(type, 0);
        if (quantity > existing) {
            throw new IllegalArgumentException("Cannot remove more than existing quantity");
        }
        int remaining = existing - quantity;

        if (remaining == 0) {
            products.remove(type);
        } else {
            products.put(type, remaining);
        }
    }

    public double calculateTotal() {
        return products.entrySet().stream().mapToDouble(e -> pricingStrategy.getPrice(client, e.getKey()) * e.getValue()).sum();
    }

    public Map<ProductType, Integer> getProducts() {
        return Map.copyOf(products);
    }

    public Client getClient() {
        return client;
    }
}
