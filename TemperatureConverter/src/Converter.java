import java.util.Objects;

public class Converter {
    public static int convertedUnit;
    public static void convert(String unit, int value) {
        if(Objects.equals(unit, "Celsius")){
            convertedUnit = (value * 9/5) + 32;
            System.out.println("\nYour temperature in Fahrenheit is " + convertedUnit + " °F");
        }
        else if(Objects.equals(unit, "Fahrenheit")){
            convertedUnit = (value - 32) * 5/9;
            System.out.println("\nYour temperature in Celsius is " + convertedUnit + " °C");
        }
    }
}
