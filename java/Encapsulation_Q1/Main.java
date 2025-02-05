package Encapsulation_Q1;

public class Main {
    public static void main(String[] args) {
        CommissionEmployee
                a = new CommissionEmployee("Basit", "Aziz", "142753869",
                2345, 0.6);
        System.out.println("Original\n"+a);

        a.setGrossSales(64589);
        a.setCommissionRate(0.65);

        System.out.println("Changed values\n" + a);

        System.out.println("\nErrors");

        CommissionEmployee b = new CommissionEmployee("Basit2", "Aziz2", "142753869",
                -2345, 14);
    }
}
