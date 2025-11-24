package org.capco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartQuantitiesTest {

    private final PricingStrategy strategy = new DefaultPricingStrategy();
    private final Client client = new IndividualClient(1, "John", "Doe");

    @Test
    void testQuantityAccumulation() {
        Cart cart = new Cart(client, strategy);
        cart.addProduct(ProductType.HIGH_END_PHONE, 1);
        cart.addProduct(ProductType.HIGH_END_PHONE, 3);

        // total quantity should be 4 * 1500
        assertEquals(6000, cart.calculateTotal());
    }

    @Test
    void testZeroQuantityAdd() {
        Cart cart = new Cart(client, strategy);
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(ProductType.LAPTOP, 0);
        });
    }

    @Test
    void testNegativeQuantityAdd() {
        Cart cart = new Cart(client, strategy);
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(ProductType.MID_RANGE_PHONE, -5);
        });
    }

    @Test
    void testRemoveMoreThanExists() {
        Cart cart = new Cart(client, strategy);
        cart.addProduct(ProductType.HIGH_END_PHONE, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeProduct(ProductType.HIGH_END_PHONE, 5);
        });
    }

    @Test
    void testAddNullProduct() {
        Cart cart = new Cart(new IndividualClient(1, "John", "Doe"), strategy);
        assertThrows(NullPointerException.class, () -> cart.addProduct(null, 1));
    }
}

