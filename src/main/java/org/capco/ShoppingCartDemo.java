package org.capco;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        PricingStrategy pricingStrategy = new DefaultPricingStrategy();

        Client individual = new IndividualClient(1, "John", "Doe");
        Client professionalBig = new ProfessionalClient(2, "Acme Corp", "REG123", 12_000_000, null);
        Client professionalSmall = new ProfessionalClient(2, "Acme Corp", "REG123", 9_000_000, null);


        Cart cart1 = new Cart(individual, pricingStrategy);
        cart1.addProduct(ProductType.HIGH_END_PHONE, 1);
        cart1.addProduct(ProductType.LAPTOP, 2);

        Cart cart2 = new Cart(professionalBig, pricingStrategy);
        cart2.addProduct(ProductType.MID_RANGE_PHONE, 3);

        Cart cart3 = new Cart(professionalSmall, pricingStrategy);
        cart3.addProduct(ProductType.MID_RANGE_PHONE, 3);
        cart3.addProduct(ProductType.LAPTOP, 5);


        System.out.println("Individual cart total: €" + cart1.calculateTotal());
        System.out.println("Professional High end cart total: €" + cart2.calculateTotal());
        System.out.println("Professional Low end cart total: €" + cart3.calculateTotal());

    }
}