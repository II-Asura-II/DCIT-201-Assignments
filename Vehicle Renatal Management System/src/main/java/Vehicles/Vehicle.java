package Vehicles;

import VRMS.Rentable;

import java.text.DecimalFormat;

public abstract class Vehicle implements Rentable {
    static DecimalFormat df = new DecimalFormat("0.00");

    private int year;
    private int rentDays;
    private int vehicleId;
    private String vehicleType;
    private String model;
    private int baseRentalRate;
    private boolean isAvailable;
    private int securityDeposit;
    private int insurance;
    public abstract int calculateRentalCost(int Days);
    public abstract boolean isAvailableForRental();

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year =
                year;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays =
                rentDays;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId =
                vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType =
                vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model =
                model;
    }

    public int getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(int baseRentalRate) {
        this.baseRentalRate =
                baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable =
                available;
    }

    public int getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(int securityDeposit) {
        this.securityDeposit =
                securityDeposit;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance =
                insurance;
    }
}
