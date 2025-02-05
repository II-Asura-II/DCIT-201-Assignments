package VRMS;


import Users.Customer;

public interface Rentable {
    int rent(Customer customer,
             int days);
    void returnVehicle(Customer customer);
}
