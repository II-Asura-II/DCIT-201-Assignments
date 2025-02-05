package Encapsulation_Q1;

import java.text.MessageFormat;

public class CommissionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setGrossSales(double grossSales) {
        try {
            this.grossSales =
                    grossSales;
            if (grossSales < 0) {
                throw new IllegalArgumentException("Number must be greater 0");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCommissionRate(double commissionRate) {
        try{
            this.commissionRate = commissionRate;
            if (commissionRate < 0 || commissionRate > 1){
                throw new IllegalArgumentException("Number must be between 0 and 1");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public CommissionEmployee(String firstName,
                              String lastName,
                              String socialSecurityNumber,
                              double grossSales,
                              double commissionRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        setCommissionRate(commissionRate);
        setGrossSales(grossSales);
    }

    public double earnings(){
        return grossSales * commissionRate;
    }

    public String toString() {
        return MessageFormat.format("Name {0} {1} \nSocial Security Number {2} \nEarnings {3}\n", firstName, lastName, socialSecurityNumber, earnings());
    }
}
