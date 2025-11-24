package org.capco;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double getPrice(Client client, ProductType type) {
        if (client.getClientType() == ClientType.INDIVIDUAL) {
            return switch (type) {
                case HIGH_END_PHONE -> 1500;
                case MID_RANGE_PHONE -> 800;
                case LAPTOP -> 1200;
            };
        } else if (client.getClientType() == ClientType.PROFESSIONAL) {
            if (client.getAnnualRevenue() > 10_000_000) {
                return switch (type) {
                    case HIGH_END_PHONE -> 1000;
                    case MID_RANGE_PHONE -> 550;
                    case LAPTOP -> 900;
                };
            } else {
                return switch (type) {
                    case HIGH_END_PHONE -> 1150;
                    case MID_RANGE_PHONE -> 600;
                    case LAPTOP -> 1000;
                };
            }
        } else {
            throw new IllegalArgumentException("Unsupported client type");
        }
    }
}
