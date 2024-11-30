package VegetableFridge;

import java.util.Scanner;
import java.time.*;

public class VegDateArray2 {
    public static void main(String[] args) {
        //creating scanner
        Scanner scanner = new Scanner(System.in);

        //initial prompt for array amount
        System.out.println("Enter how many veg you would like to store today:");
        int arraySize = scanner.nextInt();

        //arrays

        String [] vegetables = new String[arraySize];
        int [] day = new int [arraySize];
        int [] month = new int [arraySize];
        int [] year = new int [arraySize];

        //loop to get veg name, and end date

        for (int index = 0; index < arraySize; index++) {
            System.out.println("Enter vegetable name: ");
            vegetables[index] = scanner.next();
            System.out.println("Enter day: ");
            day[index] = scanner.nextInt();
            System.out.println("Enter month: ");
            month[index] = scanner.nextInt();
            System.out.println("Enter year: ");
            year[index] = scanner.nextInt();
        }

        int [] daysLeftArray = new int[arraySize];

        //work out days left

        for (int index = 0; index < arraySize; index++) {
            LocalDate today = LocalDate.now();
            LocalDate endDate = LocalDate.of(year[index],month[index],day[index]);
            daysLeftArray[index] = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate);
        }

        for (int index = 0; index < arraySize; index++) {
            System.out.println("------------------");
            System.out.println("You have a " + vegetables[index] + " that goes off on "
                    + day[index] + "." + month[index] + "." + year[index] + ".\nYou have "
                    + daysLeftArray[index] + " days left to eat this yummy vegetable.");

        }
    }
}
