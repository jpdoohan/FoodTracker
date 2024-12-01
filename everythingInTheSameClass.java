package VegetableFridge;

import java.time.LocalDate;
import java.util.Scanner;

public class everythingInTheSameClass {

    //creating scanner
    static Scanner scanner = new Scanner(System.in);

    //initialize menu
    static public int menuStatus = 0;

    //arrays
    static int arraySize = 10; //should be amended when we incorporate array list

    static String[] vegetables = new String[arraySize];
    static int[] day = new int[arraySize];
    static int[] month = new int[arraySize];
    static int[] year = new int[arraySize];
    static int[] daysLeftArray = new int[arraySize];

    static public void defaultMenu() {
        System.out.println("-----------------------");
        System.out.println("\tVeg Fridge Home");
        System.out.println("Enter:" +
                "\nTo end program:         \t-1");
        System.out.println("To display fridge contents:\t1");
        System.out.println("To update fridge contents: \t2");
        System.out.println("-----------------------");
        menuStatus = scanner.nextInt();
    }

    static public void displayFridge() {
        for (int index = 0; index < arraySize; index++) {
            System.out.println("------------------");
            System.out.println("You have a " + vegetables[index] + " that goes off on "
                    + day[index] + "." + month[index] + "." + year[index] + ".\nYou have "
                    + daysLeftArray[index] + " days left to eat this yummy vegetable.");

        }
    }

    static public void updateFridge() {
        //initial prompt for array amount
        System.out.println("Enter how many veg you would like to store today:");
        arraySize = scanner.nextInt();

        for (int index = 0; index < arraySize; index++) {
            System.out.println("Enter vegetable name: ");
            vegetables[index] = scanner.next();
            System.out.println("Enter day: ");
            day[index] = scanner.nextInt();
            System.out.println("Enter month: ");
            month[index] = scanner.nextInt();
            System.out.println("Enter year: ");
            year[index] = scanner.nextInt();

            LocalDate today = LocalDate.now();
            LocalDate endDate = LocalDate.of(year[index], month[index], day[index]);
            daysLeftArray[index] = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate);
        }
    }

    public static void main(String[] args) {

        //menu loop
        do {
            if (menuStatus == 0) {  //default menu
                defaultMenu();
            } else if (menuStatus == 1) {   //display fridge contents
                displayFridge();
                menuStatus = 0;
            } else if (menuStatus == 2) { //update fridge contents
                updateFridge();
                displayFridge();
                menuStatus = 0;
            } else {
                System.out.println("OUT OF BOUNDS");
                menuStatus = 0;
            }
        }while(menuStatus !=-1);
    }
}
