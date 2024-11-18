package GroupProject;

import java.util.Scanner;
import java.time.*;
//import java.time.* to get both the LocalDate and ChronoUnit

public class workingDateSubtraction {
    public static void main(String[] args) {

        /*
        date subtraction method- without user input
        LocalDate today = LocalDate.now(); //today's date
        LocalDate endDate = LocalDate.of(2024, 11, 26); //.of operator lets you enter a date (year/month/days)
        int daysLeft = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate); //.temporal.chronoUnit allows date subtraction - months,years etc we are using days.
        System.out.println("There are " + daysLeft + " days left");
         */

        //recieve user input and store the values
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please follow instructions on entering food end date data-");
        System.out.println("Enter end date year:");
        int year = scanner.nextInt();
        System.out.println("Enter end date month:");
        int month = scanner.nextInt();
        System.out.println("Enter end date day:");
        int day = scanner.nextInt();

        LocalDate today = LocalDate.now(); //today's date
        LocalDate endDate = LocalDate.of(year, month, day); //.of operator lets you enter a date (year/month/days)
        int daysLeft = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate); //.temporal.chronoUnit allows date subtraction - months,years etc we are using days.
        System.out.println("There are " + daysLeft + " days left");

    }
}
