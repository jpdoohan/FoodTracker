package fridge;

import java.util.Scanner;
import java.time.LocalDate;

public class fridge {
    //scanner
    static Scanner scanner = new Scanner(System.in);

    //class variables
    private int menuStatus = 0;
    private int arraySize = 10; //10 as we arent using arrayList just yet

    //arrays
    private String[] vegetables = new String[arraySize];
    private int[] day = new int[arraySize];
    private int[] month = new int[arraySize];
    private int[] year = new int[arraySize];
    private int[] daysLeftArray = new int[arraySize];

    //constructors
    public fridge() {
        //default constructor
    }

    //getters
    protected int getMenuStatus() {
        return menuStatus;
    }

    protected int getArraySize() {
        return arraySize;
    }

    protected String[] getVegetables() {
        return vegetables;
    }

    protected int[] getDay() {
        return day;
    }

    protected int[] getMonth() {
        return month;
    }

    protected int[] getYear() {
        return year;
    }

    protected int[] getDaysLeft() {
        return daysLeftArray;
    }

    //setters
    protected void setMenuStatus(int pMenuStatus) {
        menuStatus = pMenuStatus;
    }

    protected void setArraySize(int pArraySize) {
        arraySize = pArraySize;
    }

    protected void setVegetables(String[] pVegetables) {
        vegetables = pVegetables;
    }

    protected void setDay(int[] pDay) {
        day = pDay;
    }

    protected void setMonth(int[] pMonth) {
        month = pMonth;
    }

    protected void setYear(int[] pYear) {
        year = pYear;
    }

    protected void setDaysLeftArray(int[] pDaysLeft) {
        daysLeftArray = pDaysLeft;
    }

    //methods

    //default menu - status 0
    protected void defaultMenu() {
        System.out.println("-----------------------");
        System.out.println("\tVeg Fridge Home");
        System.out.println("Enter:" +
                "\nTo end program:         \t-1");
        System.out.println("To display fridge contents:\t1");
        System.out.println("To update fridge contents: \t2");
        System.out.println("-----------------------");
        menuStatus = scanner.nextInt();
    }

    //display fridge contents - status 1
    protected void printFridge() {
        for (int index = 0; index < arraySize; index++) {
            System.out.println("------------------");
            System.out.println("You have a " + vegetables[index] + " that goes off on "
                    + day[index] + "." + month[index] + "." + year[index] + ".\nYou have "
                    + daysLeftArray[index] + " days left to eat this yummy vegetable.");
        }
    }

    //update fridge - status 2
    protected void updateFridge() {
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

    //overall loop
    protected void menuLoop() {
        do {
            if (menuStatus == 0) {  //default menu
                defaultMenu();
            } else if (menuStatus == 1) {   //display fridge contents
                printFridge();
                menuStatus = 0;
            } else if (menuStatus == 2) { //update fridge contents
                updateFridge();
                printFridge();
                menuStatus = 0;
            } else {
                System.out.println("OUT OF BOUNDS");
                menuStatus = 0;
            }
        }while(menuStatus !=-1);
    }
}
