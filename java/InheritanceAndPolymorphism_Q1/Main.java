package InheritanceAndPolymorphism_Q1;

public class Main {
    public static void main(String[] args) {


        BasePlusEmployee a = new BasePlusEmployee("Basit2", "Aziz2", "142753869",
                2345, 0.2, 200);
        System.out.println("\nInherited\n"+a);

        a.setBaseSalary(2345);
        a.setCommissionRate(0.65);
        a.setGrossSales(2234);

        System.out.println("\nInherited Changed values\n" + a);

        System.out.println("\nErrors");

        BasePlusEmployee b = new BasePlusEmployee("Basit2", "Aziz2", "142753869",
                -2345, 14, -2345);
    }
}