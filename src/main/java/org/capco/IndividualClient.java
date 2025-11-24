package org.capco;

public class IndividualClient implements Client {

    private final long clientId;
    private final String firstName;
    private final String lastName;

    public IndividualClient(long clientId, String firstName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getClientName() {
        return firstName + " " + lastName;
    }

    @Override
    public ClientType getClientType() {
        return ClientType.INDIVIDUAL;
    }


    @Override
    public double getAnnualRevenue() {
        return 0;
    }
}
