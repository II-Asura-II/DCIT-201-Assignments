package Abstraction_Q1;

import java.text.MessageFormat;

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee a = new FullTimeEmployee("Basit Aziz 1", "235679", 209367);
        System.out.println(MessageFormat.format("Name: {0}\nID: {1}\nSalary: {2}\n", a.getName(), a.getEmployeeId(), a.getSalary()));

        FullTimeEmployee b = new FullTimeEmployee("Basit Aziz 1", "235679", 47845);

        FullTimeEmployee c = new FullTimeEmployee("Basit Aziz 1", "235679", 936439);

        a.calculatePay();
        b.calculatePay();
        c.calculatePay();
    }
}
