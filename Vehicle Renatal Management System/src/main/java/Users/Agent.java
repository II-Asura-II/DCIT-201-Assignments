package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agent extends User{
    public Agent(String name, int age, String address, int phone, String password) {
        setName(name);
        setAge(age);
        setAddress(address);
        setPhone(phone);
        setPassword(password);
        saveAgent();
        genIds();
    }

    private static final List<Agent> agents = new ArrayList<>();

    public static List<Agent> getAgents() {
        return agents;
    }


    private void saveAgent(){
        agents.add(this);
    }

    private void genIds() {
        int num = 0;

        while (num < agents.size()) {
            num++;
            setId(num + 1100000);
        }
    }

    protected static String crName(){
        Scanner
                uName = new Scanner(System.in);
        System.out.println("Welcome to new agent to VRMS Rental");
        System.out.println("""
                Step 1
                To begin working please enter your name:
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

    public static void  createAgent(){
        String name = crName();
        int age = crAge();
        String address = crAddress();
        int phone = crPhone();
        String password = crPassword();
        Agent agent = new Agent(name, age, address, phone, password);
    }

    public static void defaults(){
        Agent a = new Agent("John", 26, "12th Street", 552345678, "123456");
        Agent b = new Agent("Jane", 23, "13th Street", 558945678, "123456");
        Agent c = new Agent("Tom", 56, "14th Street", 552397678, "123456");
    }
}
