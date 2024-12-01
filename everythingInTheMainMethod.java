package VegetableFridge;

import java.time.LocalDate;
import java.util.Scanner;

public class everythingInTheMainMethod {
    public static void main(String[] args) {
        //creating scanner
        Scanner scanner = new Scanner(System.in);

        //initialize menu
        int menuStatus = 0;

        //arrays
        int arraySize = 10;

        String[] vegetables = new String[arraySize];
        int[] day = new int[arraySize];
        int[] month = new int[arraySize];
        int[] year = new int[arraySize];
        int[] daysLeftArray = new int[arraySize];

        //menu loop
        do {
            if (menuStatus == 0) {  //default menu

                System.out.println("-----------------------");
                System.out.println("\tVeg Fridge Home");
                System.out.println("Enter:" +
                        "\nTo end program:         \t-1");
                System.out.println("To display fridge contents:\t1");
                System.out.println("To update fridge contents: \t2");
                System.out.println("-----------------------");
                menuStatus = scanner.nextInt();

            } else if (menuStatus == 1) {   //display fridge contents

                for (int index = 0; index < arraySize; index++) {
                    System.out.println("------------------");
                    System.out.println("You have a " + vegetables[index] + " that goes off on "
                            + day[index] + "." + month[index] + "." + year[index] + ".\nYou have "
                            + daysLeftArray[index] + " days left to eat this yummy vegetable.");

                }
                menuStatus = 0;

            } else if (menuStatus == 2) { //update fridge contents

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

                    System.out.println("------------------");
                    System.out.println("You have a " + vegetables[index] + " that goes off on "
                            + day[index] + "." + month[index] + "." + year[index] + ".\nYou have "
                            + daysLeftArray[index] + " days left to eat this yummy vegetable.");

                }
                menuStatus = 0;
            } else {
                System.out.println("OUT OF BOUNDS");
                menuStatus = 0;
            }
        }while(menuStatus !=-1);
    }
}
