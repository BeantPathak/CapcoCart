Shopping Cart System – Java

This is a Java implementation of a shopping cart for an online product store. It supports individual and professional clients and three product types (high-end phone, mid-range phone, laptop) with pricing rules based on client type and revenue.

Clients are immutable data holders (IndividualClient and ProfessionalClient), and all pricing logic is encapsulated in DefaultPricingStrategy for separation of concerns. The Cart class manages product quantities and calculates totals using the pricing strategy, with validation for invalid operations.

Tests are provided with JUnit 5, covering cart totals, quantity management, and pricing rules. The ShoppingCartDemo class shows example usage and total calculations.

Design highlights: SRP/OCP compliance, efficient EnumMap for products, and immutable clients for safe state.
