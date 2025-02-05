package Abstraction_Q1;

public class FullTimeEmployee extends Employee{
    private double salary;

    public FullTimeEmployee(String name, String employeeId, double salary) {
        super(name, employeeId);
        this.salary = salary;
    }

    @Override
    public void calculatePay() {
        System.out.println("FullTimeEmployee Pay: " + salary);
    }

    public double getSalary() {
        return salary;
    }
}
