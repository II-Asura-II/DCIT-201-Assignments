package Users;

import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private String address;
    private int phone;
    private int id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =
                name;
    }


    public void setAge(int age) {
        this.age =
                age;
    }

    public void setAddress(String address) {
        this.address =
                address;
    }

    public void setPhone(int phone) {
        this.phone =
                phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =
                id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =
                password;
    }

    protected static int crAge(){
        int age=0;
        Scanner
                uAge = new Scanner(System.in);
        System.out.println("""
                Step 2
                Please enter your age:
                """);
        try {
            age = uAge.nextInt();
            if(age<18) {
                System.out.println("""
                        You are not eligible to rent a car
                        You must be 18 or above to rent a car
                        """);
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid age");
            crAge();
        }
        return age;
    }

    protected static String crAddress(){
        Scanner uAddress = new Scanner(System.in);
        String address="";
        System.out.println("""
                Step 3
                Please enter your current home address:
                """);
        try {
            address = uAddress.nextLine();
        }
        catch (Exception e) {
            System.out.println("Please enter a valid address");
            crAddress();
        }
        return address;
    }

    public static int countDigits(int number){
        int count=0;

        while (number!=0) {
            number=number/10;
            count++;
        }
        return count;
    }

    protected static int crPhone(){
        Scanner uPhone = new Scanner(System.in);
        int phone=0;
        System.out.println("""
                Step 4
                Please enter your phone number:
                """);

        try {
            phone =uPhone.nextInt();
        }
        catch (Exception e) {
            System.out.println("Please enter a valid phone number");
            crPhone();
        }


        if(countDigits(phone) != 9){
            System.out.println("Please enter a valid phone number");
            crPhone();
        }

        return phone;
    }

    protected static String crPassword(){
        Scanner uPassword = new Scanner(System.in);
        String password="";
        System.out.println("""
                Step %
                Please create a password:
                """);
        try {
            password = uPassword.nextLine();
        }
        catch (Exception e) {
            System.out.println("Please enter a valid password");
        }
        return password;
    }
}
