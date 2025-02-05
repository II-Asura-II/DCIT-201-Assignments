import java.util.Scanner;

public class UserTemperature {
    public static String unit;
    public static int value;
    public static void enterTemperature() {
        System.out.println("What units are you using\n1.Celsius(°C)\n2.Fahrenheit(°F)\n\nEnter 1 or 2:");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        if(userInput == 1){
            unit = "Celsius";
            System.out.println("\nPlease provide the temperature value to convert to Fahrenheit");
            Scanner in = new Scanner(System.in);
            value = in.nextInt();
        }
        else if(userInput == 2){
            unit = "Fahrenheit";
            System.out.println("\nPlease provide the temperature value to convert to Celsius");
            Scanner in = new Scanner(System.in);
            value = in.nextInt();
        }

    }
}
