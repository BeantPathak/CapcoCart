package org.capco;

public class ProfessionalClient implements Client {
    private final long clientId;
    private final String companyName;
    private final String registrationNumber;
    private final double annualRevenue;
    private final String vatNumber; // optional, can be null

    public ProfessionalClient(long clientId, String companyName, String registrationNumber, double annualRevenue, String vatNumber) {
        this.clientId = clientId;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.annualRevenue = annualRevenue;
        this.vatNumber = vatNumber;
    }

    @Override
    public String getClientName() {
        return companyName;
    }

    @Override
    public ClientType getClientType() {
        return ClientType.PROFESSIONAL;
    }


    @Override
    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public String getVatNumber() {
        return vatNumber;
    }
}