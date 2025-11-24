package org.capco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultPricingStrategyTest {
    private final PricingStrategy strategy = new DefaultPricingStrategy();

    @Test
    void testIndividualPricing() {
        Client c = new IndividualClient(1, "John", "Doe");
        assertEquals(1500, strategy.getPrice(c, ProductType.HIGH_END_PHONE));
        assertEquals(800, strategy.getPrice(c, ProductType.MID_RANGE_PHONE));
        assertEquals(1200, strategy.getPrice(c, ProductType.LAPTOP));
    }

    @Test
    void testProfessionalHighRevenuePricing() {
        Client c = new ProfessionalClient(2, "Big Corp", "REG1", 12_000_000, null);
        assertEquals(1000, strategy.getPrice(c, ProductType.HIGH_END_PHONE));
        assertEquals(550, strategy.getPrice(c, ProductType.MID_RANGE_PHONE));
        assertEquals(900, strategy.getPrice(c, ProductType.LAPTOP));
    }

    @Test
    void testProfessionalLowRevenuePricing() {
        Client c = new ProfessionalClient(3, "Small Biz", "REG2", 5_000_000, null);
        assertEquals(1150, strategy.getPrice(c, ProductType.HIGH_END_PHONE));
        assertEquals(600, strategy.getPrice(c, ProductType.MID_RANGE_PHONE));
        assertEquals(1000, strategy.getPrice(c, ProductType.LAPTOP));
    }
}