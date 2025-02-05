package RentalAgency;


import Users.Customer;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Truck;
import Vehicles.Vehicle;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Scanner;



public class RentalTransaction {
    private static int totalCost;
    private static boolean approval;

    public static void setApproval(boolean approval) {
        RentalTransaction.approval =
                approval;
    }

    public static void setTotalCost(int totalCost) {
        RentalTransaction.totalCost = totalCost;
    }

    static DecimalFormat df = new DecimalFormat("0.00");

    public static void carTransaction(Customer customer){
        Car.defaults();
        System.out.println("This is the current selection of cars");
        Car.listStock();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the car you want to rent:");
        int carNumber = input.nextInt();

        for(Car car : Car.getCars()){
            if(carNumber == (car.getVehicleId() - 4000000)){
                selection(car, customer);
            }
        }
    }

    public static void motorcycleTransaction(Customer customer){
        Motorcycle.defaults();
        System.out.println("This is the current selection of Motorcycles");
        Motorcycle.listStock();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the motorcycle you want to rent:");
        int motorcycleNumber = input.nextInt();

        for(Motorcycle motorcycle : Motorcycle.getMotorcycles()){
            if(motorcycleNumber == (motorcycle.getVehicleId() - 2000000)){
                selection(motorcycle, customer);
            }
        }
    }

    public static void truckTransaction(Customer customer){
        Truck.defaults();
        System.out.println("This is the current selection of Trucks");
        Truck.listStock();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the truck you want to rent:");
        int truckNumber = input.nextInt();

        for(Truck truck : Truck.getTrucks()){
            if(truckNumber == (truck.getVehicleId() - 3000000)){
                selection(truck, customer);
            }
        }
    }

    public static void selection(Vehicle vehicle, Customer customer){
        System.out.println("You have selected " + vehicle.getModel());
        Scanner in = new Scanner(System.in);
        System.out.println("How long do you wish to the " + vehicle.getVehicleType() + " rent for?\n(Enter the number of days)");
        int days = in.nextInt();
        RentalTransaction.setTotalCost(vehicle.calculateRentalCost(days));
        System.out.println("Insurance: " + vehicle.getInsurance());
        System.out.println("Security Deposit: " + vehicle.getSecurityDeposit());
        int rentCost = vehicle.calculateRentalCost(days);
        System.out.println("Rent Cost: " + rentCost);

        confirmation(vehicle, customer, rentCost);
    }

    public static void confirmation(Vehicle vehicle, Customer customer, int rentCost){
        Scanner in = new Scanner(System.in);
        System.out.println("Do you wish to rent?(Y/N)");
        String confirm = (in.nextLine()).toLowerCase();
        if(confirm.equals("y")){
            System.out.println("Your request to rent the " + vehicle.getModel() + " is being processed");
            if(approval && customer.checkRentalEligibilty() && vehicle.isAvailableForRental()){
                System.out.println(MessageFormat.format("Congratulations {0} on renting a {1}", customer.getName(), vehicle));
                setTotalCost(vehicle.rent(customer, rentCost));
                System.out.println("The total cost of renting the " + vehicle.getModel() + " is GHS" + totalCost);
                System.out.println("Thank you for renting using VRMS");
                rentAgain(customer);
            }
        }
        if(confirm.equals("n")){
            rentAgain(customer);
        }
    }

    public static void rentAgain(Customer customer){
        Scanner in2 = new Scanner(System.in);
        System.out.println("Do you wish to rent another vehicle?(Y/N)");
        String confirm2 = (in2.nextLine()).toLowerCase();
        if(confirm2.equals("y")){
            RentalAgency.startRenting(customer);
        }
        else if(confirm2.equals("n")) {
            System.out.println("Thank you for using VRMS");
            System.exit(0);
        }
    }
}
