package org.capco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartDemoTest {

    private PricingStrategy pricingStrategy;
    private Client individual;
    private Client professionalHighRevenue;
    private Client professionalLowRevenue;

    @BeforeEach
    void setup() {
        pricingStrategy = new DefaultPricingStrategy();
        individual = new IndividualClient(1, "John", "Doe");
        professionalHighRevenue = new ProfessionalClient(2, "Acme Corp", "REG123", 12_000_000, null);
        professionalLowRevenue = new ProfessionalClient(3, "Startup Inc", "REG456", 5_000_000, null);
    }

    @Test
    void testIndividualCartTotal() {
        Cart cart = new Cart(individual, pricingStrategy);
        cart.addProduct(ProductType.HIGH_END_PHONE, 1);
        cart.addProduct(ProductType.MID_RANGE_PHONE, 2);
        cart.addProduct(ProductType.LAPTOP, 1);

        // Expected: 1*1500 + 2*800 + 1*1200 = 4300
        assertEquals(4300, cart.calculateTotal());
    }

    @Test
    void testProfessionalHighRevenueCartTotal() {
        Cart cart = new Cart(professionalHighRevenue, pricingStrategy);
        cart.addProduct(ProductType.HIGH_END_PHONE, 1);
        cart.addProduct(ProductType.MID_RANGE_PHONE, 2);
        cart.addProduct(ProductType.LAPTOP, 1);

        // Expected: 1*1000 + 2*550 + 1*900 = 3000
        assertEquals(3000, cart.calculateTotal());
    }

    @Test
    void testProfessionalLowRevenueCartTotal() {
        Cart cart = new Cart(professionalLowRevenue, pricingStrategy);
        cart.addProduct(ProductType.HIGH_END_PHONE, 1);
        cart.addProduct(ProductType.MID_RANGE_PHONE, 2);
        cart.addProduct(ProductType.LAPTOP, 1);

        // Expected: 1*1150 + 2*600 + 1*1000 = 3350
        assertEquals(3350, cart.calculateTotal());
    }

    @Test
    void testRemoveProductFromCart() {
        Cart cart = new Cart(individual, pricingStrategy);
        cart.addProduct(ProductType.HIGH_END_PHONE, 2);
        cart.removeProduct(ProductType.HIGH_END_PHONE, 1);

        // Expected: 1 * 1500 = 1500
        assertEquals(1500, cart.calculateTotal());
    }

    @Test
    void testEmptyCartTotal() {
        Cart cart = new Cart(individual, pricingStrategy);
        assertEquals(0, cart.calculateTotal());
    }
}

