package Users;



import RentalAgency.RentalAgency;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User{
    private boolean eligible;

    private final List<Vehicle> rentals = new ArrayList<>();

    public void addRental(Vehicle vehicle){
        rentals.add(vehicle);
    }

    public void removeRental(Vehicle vehicle){
        rentals.remove(vehicle);
    }

    public List<Vehicle> getRentals() {
        return rentals;
    }

    public void listRentals(){
        int num = 1;

        for(Vehicle vehicle : rentals){
            System.out.println(num + ". " + vehicle + "id: " + vehicle.getVehicleId());
        }
    }

    public void returnVehicle(int vehicleId){
        for(Vehicle vehicle : rentals){
            if(vehicle.getVehicleId() == vehicleId){
                vehicle.returnVehicle(this);
            }
        }
    }

    private final List<Vehicle> rentalHistory = new ArrayList<>();

    public void addRentalHistory(Vehicle vehicle){
        rentalHistory.add(vehicle);
    }

    public List<Vehicle> getRentalHistory() {
        return rentalHistory;
    }

    public static void manageRentalHistory(Customer customer){
        int num = 1;

        for (Vehicle vehicle : customer.getRentalHistory()){
            System.out.println(num + ". " + vehicle.getModel() + ' ' + vehicle.getRentDays());
            num++;
        }
    }

    public static Vehicle getVehicle(Customer customer, int vehicleId) {
        for (Vehicle vehicle: customer.getRentals()) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

    public Customer(String name, int age, String address, int phone, String password) {
        this.eligible = true;
        setName(name);
        setAge(age);
        setAddress(address);
        setPhone(phone);
        setPassword(password);
        saveCustomer();
        genIds();
    }

    private static final List<Customer> customers = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void listCustomers(){
        for (Customer customer : customers) {
                System.out.println((customer.getId() - 1000000) + ". " + customer.getName());
        }
    }

    public static void listCustomerRentals(Customer customer) {
                for (Vehicle vehicle : customer.getRentals()) {
                    System.out.println(customer.getName() + " Unprocessed rentals");
                    System.out.println(vehicle.getModel() + '(' + vehicle.getVehicleId() + ") for " + vehicle.getRentDays() + " " +
                            "days");
                }
            }



    public static Customer getCustomer(int id){
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    protected static String crName(){
        Scanner
                uName = new Scanner(System.in);
        System.out.println("Welcome to VRMS Rental");
        System.out.println("""
                Step 1
                To begin renting please enter your name:
                """);
        String name="";
        try {
            name = uName.nextLine();
        }
        catch (Exception e) {
            System.out.println("Please enter a valid name");
            crName();
        }
        return name;
    }

    private void saveCustomer(){
            customers.add(this);
    }

    private void genIds() {
        int num = 0;

        while (num < customers.size()) {
            num++;
            setId(num + 1000000);
        }
    }



    public static void  createCustomer(){
        String name = crName();
        int age = crAge();
        String address = crAddress();
        int phone = crPhone();
        String password = crPassword();
        Customer customer = new Customer(name, age, address, phone, password);
        RentalAgency.startRenting(customer);
    }

    public boolean checkRentalEligibilty(){
        return eligible;
    }

    public static void defaults(){
        Customer a = new Customer("John", 23, "10th Street", 269733449, "123456");
        Customer b = new Customer("Jane", 22, "11th Street", 223870119, "123456");
    }
}
