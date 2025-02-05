package Vehicles;


import Users.Customer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static RentalAgency.RentalAgency.removeVehicle;

public class Motorcycle extends Vehicle{
    private final String type;

    private static final List<Motorcycle> motorcycles = new ArrayList<>();

    public static List<Motorcycle> getMotorcycles() {
        return motorcycles;
    }

    private void saveMotorcycle() {
        if (this.isAvailable()) {
            motorcycles.add(this);
        }
    }

    public void removeMotorcycle() {
        motorcycles.remove(this);
    }

    public static void removeMotorcycleFromFleet(){
        int num = 1;
        Scanner
                sc = new Scanner(System.in);
        System.out.println("""
                Enter the id of the car you wish to remove
                Enter 1 to return""");
        for(Motorcycle motorcycle : motorcycles) {
            System.out.println(MessageFormat.format("{0}. {1}({2}) {3}",
                    num, motorcycle.getModel(), motorcycle.getVehicleId(), motorcycle.getYear()));
            num++;
        }

        int choice = sc.nextInt();
        if (choice == 1) {
            removeVehicle();
        }
        else {
            for (Motorcycle motorcycle : motorcycles) {
                if (motorcycle.getVehicleId() == choice) {
                    motorcycle.removeMotorcycle();
                }
            }
        }
    }

    public static void listStock() {
        for (Motorcycle motorcycle : motorcycles) {
            System.out.println((motorcycle.getVehicleId() - 2000000) + ". " + motorcycle.getModel() + ' ' + motorcycle.getYear() + '(' + motorcycle.type + ')');
        }
        System.out.println("Save up to 50% in taxes by renting an electric car");
    }

    public int rent(Customer customer, int rentCost) {
        customer.addRental(this);
        customer.addRentalHistory(this);
        return calculateTotalCost(rentCost);
    }

    public void returnVehicle(Customer customer) {
        customer.removeRental(this);
    }

    private void genIds() {
        int num = 0;

        while (num < motorcycles.size()) {
            num++;
            setVehicleId(num + 2000000);
        }
    }

    public Motorcycle(String model, int year, String type) {
        super();
        setModel(model);
        setYear(year);
        this.type = type;
        setAvailable(true);
        saveMotorcycle();
        genIds();
        setBaseRentalRate();
        this.setVehicleType("motorcycle");
    }


    private void setBaseRentalRate(){
        switch (type) {
            case "Scooter" -> setBaseRentalRate(35);
            case "Standard" -> setBaseRentalRate(75);
            case "Cruiser" -> setBaseRentalRate(115);
            case "Sport" -> setBaseRentalRate(150);
            case "Dirt Bike" -> setBaseRentalRate(110);
            case "Electric" -> setBaseRentalRate(70);
        }

        setInsurance(170 + getBaseRentalRate());
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

    public static void defaults() {
        Motorcycle a = new Motorcycle("Harley-Davidson Softail", 2019, "Cruiser");
        Motorcycle b = new Motorcycle("Yamaha YZF-R1", 2020, "Sport");
        Motorcycle c = new Motorcycle("Kawasaki Z900", 2024, "Standard");
        Motorcycle d = new Motorcycle("KTM 450 SX-F", 2022, "Dirt Bike");
        Motorcycle e = new Motorcycle("Vespa GTS 300", 2024, "Scooter");
        Motorcycle f = new Motorcycle("Zero SR/F", 2023, "Electric");
    }
}