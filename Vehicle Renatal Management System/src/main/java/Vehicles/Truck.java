package Vehicles;

import Users.Customer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static RentalAgency.RentalAgency.removeVehicle;


public class Truck extends Vehicle{
    private final String type;

    private static final List<Truck> trucks = new ArrayList<>();

    public static List<Truck> getTrucks() {
        return trucks;
    }

    private void saveTrucks(){
        if(this.isAvailable()) {
            trucks.add(this);
        }
    }

    public void removeTruck(){
        trucks.remove(this);
    }

    public static void removeTruckFromFleet(){
        int num = 1;
        Scanner
                sc = new Scanner(System.in);
        System.out.println("""
                Enter the id of the car you wish to remove
                Enter 1 to return""");
        for(Truck truck : trucks){
            System.out.println(MessageFormat.format("{0}. {1}({2}) {3}",
                    num, truck.getModel(), truck.getVehicleId(), truck.getYear()));
            num++;
        }

        int choice = sc.nextInt();
        if (choice == 1) {
            removeVehicle();
        }
        else {
            for (Truck truck : trucks) {
                if (truck.getVehicleId() == choice) {
                    truck.removeTruck();
                }
            }
        }
    }

    public static void listStock(){
        System.out.println("Note: Rental cost does not include insurance and security deposit.");
        for(Truck truck: trucks){
            System.out.println((truck.getVehicleId() - 3000000) + ". " + truck.getModel() + ' ' + truck.getYear() + '(' + truck.type + ')'+
                    " - "
                    + "GHS " + df.format(truck.getBaseRentalRate()));
        }
    }


    private void genIds() {
        int num = 0;

        while (num < trucks.size()) {
            num++;
            setVehicleId(num + 3000000);
        }
    }

    public Truck(String model, int year ,String type) {
        super();
        setModel(model);
        setYear(year);
        this.type = type;
        setAvailable(true);
        saveTrucks();
        genIds();
        setBaseRentalRate();
        setVehicleType("truck");
    }

    private void setBaseRentalRate(){
        switch (type) {
            case "Pickup" -> setBaseRentalRate(1125);
            case "Dump" -> setBaseRentalRate(2250);
            case "Box", "Tow" -> setBaseRentalRate(1750);
            case "Semi" -> setBaseRentalRate(4500);
            case "Tank" -> setBaseRentalRate(3000);
            case "Garbage" -> setBaseRentalRate(3250);
            case "Refrigerator" -> setBaseRentalRate(2500);
        }

        setInsurance(200 + getBaseRentalRate());
        setSecurityDeposit(getBaseRentalRate() * 2);
    }

    public int calculateRentalCost(int Days) {
        setRentDays(Days);
        return getBaseRentalRate() * getRentDays();

    }

    public int calculateTotalCost(int rentCost){
        return rentCost+ getInsurance() + getSecurityDeposit();
    }

    public boolean isAvailableForRental() {
        return isAvailable();
    }

    public static void defaults(){
        Truck a = new Truck("Toyota Hilux", 2024, "Pickup");
        Truck b = new Truck("Volvo FMX", 2024, "Dump");
        Truck c = new Truck("Mercedes-Benz Sprinter", 2021, "Box");
        Truck d = new Truck("Scania R-Series", 2023, "Semi");
        Truck e = new Truck("Kenworth T680", 2020, "Tank");
        Truck f = new Truck("Volvo FH", 2022, "Refrigerator");
        Truck g = new Truck("DAF LF", 2024, "Garbage");
        Truck h = new Truck("Ford F-450", 2020, "Tow");
    }

    @Override
    public int rent(Customer customer, int rentCost) {
        customer.addRental(this);
        customer.addRentalHistory(this);
        return calculateTotalCost(rentCost);
    }

    @Override
    public void returnVehicle(Customer customer) {
        customer.removeRental(this);
    }
}
