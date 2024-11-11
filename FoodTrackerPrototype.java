package GroupProject;

import java.util.Scanner;
import java.util.Calendar;

public class FoodTrackerPrototype {
GDFGD
    public static void main(String[] args) { //main
        Scanner scanner = new Scanner(System.in); //scanner object

        //variables
        String food = "food";
        int date;
        int daysLeft;

        //user prompts
        System.out.println("Enter food");
        food = scanner.nextLine();

        System.out.println("Enter date");
        date = scanner.nextInt();

        //days left calculation - basic
        daysLeft = date - Calendar.getInstance().get(Calendar.DATE);

        //print current day
        System.out.println(Calendar.getInstance().get(Calendar.DATE));

        //feedback
        System.out.println("You have " + daysLeft + " days left to eat " + food);

    }
}
