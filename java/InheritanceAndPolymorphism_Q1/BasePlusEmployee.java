package InheritanceAndPolymorphism_Q1;

import Encapsulation_Q1.CommissionEmployee;

public class BasePlusEmployee extends CommissionEmployee{
    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        try {
            this.baseSalary =
                    baseSalary;
            if(baseSalary <= 0){
                throw new IllegalArgumentException("Base Salary must be greater than 0");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public BasePlusEmployee(String firstName,
                            String lastName,
                            String socialSecurityNumber,
                            double grossSales,
                            double commissionRate,
                            double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        setBaseSalary(baseSalary);
    }

    @Override
    public double earnings() {
        return super.earnings() + baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + ", \nBase Salary: " + baseSalary;
    }
}