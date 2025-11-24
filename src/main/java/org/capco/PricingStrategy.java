package org.capco;

public interface PricingStrategy {
    double getPrice(Client client, ProductType type);
}
