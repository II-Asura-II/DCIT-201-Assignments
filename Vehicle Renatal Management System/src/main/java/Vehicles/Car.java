package Vehicles;


import Users.Customer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static RentalAgency.RentalAgency.removeVehicle;


public class Car extends Vehicle{
    private final String type;



    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> getCars() {
        return cars;
    }

    private void saveCars(){
        if(this.isAvailable()) {
            cars.add(this);
        }
    }

    public void removeCar(){
        cars.remove(this);
    }

    public static void removeCarFromFleet(){
        int num = 1;
        Scanner
                sc = new Scanner(System.in);
        System.out.println("""
                Enter the id of the car you wish to remove
                Enter 1 to return""");
        for(Car car : cars){
            System.out.println(MessageFormat.format("{0}. {1}({2}) {3}",
                    num, car.getModel(), car.getVehicleId(), car.getYear()));
            num++;
        }

        int choice = sc.nextInt();
        if (choice == 1) {
            removeVehicle();
        }
        else {
            for (Car car : cars) {
                if (car.getVehicleId() == choice) {
                    car.removeCar();
                }
            }
        }
    }

    public static void listStock(){
        System.out.println("Note: Rental cost does not include insurance and security deposit.");
        for(Car car: cars){
            System.out.println((car.getVehicleId() - 4000000) + ". " + car.getModel() + ' ' + car.getYear() + '(' + car.type + ')'+
                               " - " + "GHS " + df.format(car.getBaseRentalRate()));
        }
    }

    private void genIds() {
        int num = 0;

        while (num < cars.size()) {
            num++;
            setVehicleId(num + 4000000);
            }
    }

    public Car(String model, int year ,String type) {
        super();
        setModel(model);
        setYear(year);
        this.type = type;
        setAvailable(true);
        saveCars();
        genIds();
        setBaseRentalRate();
        setVehicleType("car");
    }

    private void setBaseRentalRate(){
        switch (type) {
            case "Sedan" -> setBaseRentalRate(45);
            case "Hatchback" -> setBaseRentalRate(55);
            case "SUV" -> setBaseRentalRate(110);
            case "Convertible" -> setBaseRentalRate(150);
            case "Crossover" -> setBaseRentalRate(90);
            case "Coupe" -> setBaseRentalRate(130);
            case "Luxury", "Sports" -> setBaseRentalRate(225);
            case "Hybrid" -> setBaseRentalRate(75);
            case "Electric" -> setBaseRentalRate(105);
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
        Car a = new Car("Toyota Camry", 2023, "Sedan");
        Car b = new Car("Honda CR-V", 2021, "SUV");
        Car c = new Car("Mazda MX-5 Miata", 2022, "Convertible");
        Car d = new Car("BMW 4 Series", 2024, "Coupe");
        Car e = new Car("Mercedes-Benz S-Class", 2024, "Luxury");
        Car f = new Car("Porsche 911", 2020, "Sports");
        Car g = new Car("Tesla Model 3", 2024, "Electric");
        Car h = new Car("Toyota Prius", 2023, "Hybrid");
        Car i = new Car("Honda Civic", 2021, "Hatchback");
    }

    public int rent(Customer customer, int rentCost) {
        customer.addRental(this);
        customer.addRentalHistory(this);
        return calculateTotalCost(rentCost);
    }

    public void returnVehicle(Customer customer) {
        customer.removeRental(this);
    }
}
