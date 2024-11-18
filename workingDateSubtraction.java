package GroupProject;

import java.time.*;
//import java.time.* to get both the LocalDate and ChronoUnit

public class workingDateSubtraction {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); //today's date
        LocalDate endDate = LocalDate.of(2024, 11, 26); //.of operator lets you enter a date (year/month/days)
        int daysLeft = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate); //.temporal.chronoUnit allows date subtraction - months,years etc we are using days.
        System.out.println("There are " + daysLeft + " days left");
    }
}
