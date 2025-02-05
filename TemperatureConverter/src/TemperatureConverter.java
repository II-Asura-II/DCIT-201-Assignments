import java.util.Objects;
import java.util.Scanner;

public class TemperatureConverter {
    public static void temperatureConvert() {
        System.out.println("====Temperature Converter====\n");
        UserTemperature.enterTemperature();
        Converter.convert(UserTemperature.unit, UserTemperature.value);

        System.out.println("\nDo you wish to exit the program? (y/n)");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (Objects.equals(s, "y")) {
            System.out.println("\nThank you for using Temperature Converter!\n");
            System.exit(0);
        }
        else {
            System.out.println("\nWelcome back to the Temperature Converter!\n");
            temperatureConvert();
        }
    }
}
