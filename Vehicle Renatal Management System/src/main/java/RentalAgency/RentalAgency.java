package RentalAgency;


import Users.Agent;
import Users.Customer;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Truck;
import Vehicles.Vehicle;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Scanner;

import static Vehicles.Car.removeCarFromFleet;
import static Vehicles.Motorcycle.removeMotorcycleFromFleet;
import static RentalAgency.RentalTransaction.*;
import static Vehicles.Truck.removeTruckFromFleet;


public class RentalAgency {

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Welcome to VRMS Rentals
                1. Login as a Customer
                2. Login as a Agent
                3. Sign up
                Please enter 1, 2 or 3
                """);
        int choice = sc.nextInt();

        switch (choice){
            case 1 -> loginCustomer();
            case 2 -> loginAgent();
            case 3 -> Customer.createCustomer();
        }
    }

    public static void loginCustomer() {
        Customer.defaults();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = sc1.nextLine().toLowerCase();
        for (Customer customer : Customer.getCustomers()) {
            if (username.equals(customer.getName().toLowerCase())) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Please enter your password:");
                String password = sc2.nextLine();
                if (password.equals(customer.getPassword())) {
                    startBusiness(customer);
                }
                else {
                    System.out.println("Wrong password or username!");
                    loginCustomer();
                }
            }
        }
    }

    public static void startBusiness(Customer customer) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Hello " + customer.getName());
        System.out.println("""
                            What would you like to do today?
                            1. Rent a vehicle
                            2. Check current rentals
                            3. Manage rental history
                            4. Return a vehicle
                            Please enter 1, 2, 3 or 4
                            """);
        int choice = sc1.nextInt();

        switch (choice){
            case 1 -> startRenting(customer);
            case 2 -> Customer.listCustomerRentals(customer);
            case 3 -> Customer.manageRentalHistory(customer);
            case 4 -> returnVehicle(customer);
        }
    }

    public static void startRenting(Customer customer) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello "+ customer.getName());
        System.out.println("""
                What type of Vehicle do you wish to rent today?
                1.Car
                2.Motorcycle
                3.Truck
                Please enter 1, 2 or 3
                """);

        int vehicleType = input.nextInt();
        typeSelection(vehicleType, customer);
    }

    public static void returnVehicle(Customer customer) {
        Scanner sc1 = new Scanner(System.in);
        customer.listRentals();
        System.out.println("Enter the id of the car you wish to return: ");
        int id = sc1.nextInt();
        customer.returnVehicle(id);
    }

    public static void typeSelection(int vehicleType, Customer customer) {
        switch (vehicleType){
            case 1 -> carTransaction(customer);
            case 2 -> motorcycleTransaction(customer);
            case 3 -> truckTransaction(customer);
        }
    }

    public static void loginAgent(){
        Agent.defaults();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = sc1.nextLine().toLowerCase();
        for (Agent agent : Agent.getAgents()) {
            if (username.equals(agent.getName().toLowerCase())) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Please enter your password:");
                String password = sc2.nextLine();
                if (password.equals(agent.getPassword())) {
                    System.out.println("Your agent has been successfully logged in!");
                    startWork();
                }
                else {
                    System.out.println("Wrong password or username!");
                    loginAgent();
                }
            }
        }
    }

    public static void startWork(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                What do you wish to do today
                1. Manage vehicle fleet
                2. Process rentals
                3. Generate reports
                4. Register a new agent
                Please enter 1, 2, 3 or 4
                """);
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> viewStock();
            case 2 -> processRentals();
            case 3 -> generateReports();
            case 4 -> Agent.createAgent();
        }
    }

    public static void manageVehicleFleet(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Manage vehicle fleet
                1. View current stock of vehicles
                2. Add new vehicle
                3. Remove vehicle
                4. Return
                Please enter 1, 2, 3 or 4
                """);
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> viewStock();
            case 2 -> createVehicle();
            case 3 -> removeVehicle();
            case 4 -> startWork();
        }
    }

    public static void removeVehicle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                What type of vehicle do you wish to remove?
                1. Car
                2. Motorcycle
                3. Truck
                4. Return
                Please enter 1, 2, 3 or 4
                """);
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> removeCarFromFleet();
            case 2 -> removeMotorcycleFromFleet();
            case 3 -> removeTruckFromFleet();
            case 4 -> manageVehicleFleet();
        }
    }

    public static void createVehicle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                What type of vehicle do you wish to add?
                1. Car
                2. Motorcycle
                3. Truck
                4. Return
                Please enter 1, 2, 3 or 4
                """);
        int vehicleType = sc.nextInt();
        String model = crVehicleModel();
        String type = crType();
        int year = crYear();

        switch (vehicleType){
            case 1 -> {
                Car
                        car = new Car(model, year, type);}
            case 2 -> {
                Motorcycle
                        motorcycle = new Motorcycle(model, year, type);}
            case 3 -> {
                Truck
                        truck = new Truck(model, year, type);}
            case 4 -> manageVehicleFleet();
        }
    }

    protected static String crVehicleModel(){
        String vehicleModel = "";
        Scanner
                uModel = new Scanner(System.in);
        System.out.println("Please enter your vehicle model:");
        try {
            vehicleModel = uModel.nextLine();
        } catch (Exception e) {
            System.out.println("Please enter a valid model name");
            crVehicleModel();
        }

        return vehicleModel;
    }

    protected static String crType(){
        Scanner uType = new Scanner(System.in);
        String type="";
        System.out.println("Enter the type of the vehicle:");
        try {
            type = uType.nextLine();
        }
        catch (Exception e) {
            System.out.println("Please enter a valid type");
            crType();
        }
        return type;
    }

    protected static int crYear(){
        Scanner uYear = new Scanner(System.in);
        int year=0;
        System.out.println("Please enter the manufacturing year:");

        try {
            year =uYear.nextInt();
        }
        catch (Exception e) {
            System.out.println("Please enter a valid year");
            crYear();
        }

        return year;
    }

    public static void viewStock(){
        Scanner sc = new Scanner(System.in);
        System.out.println(MessageFormat.format("""
                Which vehicles do you wish to view?
                1. Cars - {0} in stock
                2. Motorcycles - {1} in stock
                3. Trucks - {2} in stock
                Please enter 1, 2 or 3
                """,
                Car.getCars().size(), Motorcycle.getMotorcycles().size(), Truck.getTrucks().size()));
        int vehicleType = sc.nextInt();

        switch (vehicleType){
            case 1 -> Car.listStock();
            case 2 -> Motorcycle.listStock();
            case 3 -> Truck.listStock();
        }
    }

    public static void processRentals(){
        Customer.defaults();
        Customer.listCustomers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the customer you wish to select");
        int choice = sc.nextInt() + 1000000;
        Customer.listCustomerRentals(Objects.requireNonNull(Customer.getCustomer(choice)));
        System.out.println(Customer.getCustomer(choice));
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the id of the vehicle you wish to approve");
        int id = sc1.nextInt();
        System.out.println(MessageFormat.format("You have approved the rental of {0} by {1}", Objects.requireNonNull(Customer.getVehicle(Objects.requireNonNull(Customer.getCustomer(choice))
                , id)).getModel(), Objects.requireNonNull(Customer.getCustomer(choice)).getName()));
        RentalTransaction.setApproval(true);
    }

    public static void generateReports(){
        for (Customer customer : Customer.getCustomers()) {
            System.out.println(customer.getName());
            System.out.println("Current rentals");
            for (Vehicle vehicle: customer.getRentals()){
                System.out.println(MessageFormat.format("{0} for {1} days - GHS {2}",
                        vehicle.getModel(), vehicle.getRentDays(), df.format(vehicle.calculateRentalCost(vehicle.getRentDays()))));
            }
        }
    }

}
