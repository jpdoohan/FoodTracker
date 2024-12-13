package fridge;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;


public class fridge {
    //scanner
    static Scanner scanner = new Scanner(System.in);
    static FileReader myFileName;
    static Scanner readMyFile;
    static PrintWriter myOutFile;

    //class variables
    private int menuStatus = 0;
    private int arraySize = 0; //initialize-will alter later

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
        for (int index = 0; index < getArraySize(); index++) {
            System.out.println("------------------");
            System.out.println("You have a " + getVegetables()[index] + " that goes off on "
                    + getDay()[index] + "." + getMonth()[index] + "." + getYear()[index] + ".\nYou have "
                    + getDaysLeft()[index] + " days left to eat this yummy food product.");
        }
    }

    //update fridge - status 2
    protected void updateFridge() {
        //initial prompt for array amount
        System.out.println("Enter how many food items you would like to store today:");
        int increase = scanner.nextInt();
        arraySize = arraySize + increase;

        //create dummy arrays to swap values
        String [] dummyVegetables = new String[arraySize];
        System.arraycopy(vegetables, 0, dummyVegetables, 0, vegetables.length);
        int [] dummyDay = new int[arraySize];
        System.arraycopy(day, 0, dummyDay, 0, day.length);
        int [] dummyMonth = new int[arraySize];
        System.arraycopy(month, 0, dummyMonth, 0, month.length);
        int [] dummyYear = new int[arraySize];
        System.arraycopy(year, 0, dummyYear, 0, year.length);
        int [] dummyDaysLeft = new int[arraySize];
        System.arraycopy(daysLeftArray, 0, dummyDaysLeft, 0, daysLeftArray.length);

        for (int index = (arraySize - increase); index < arraySize; index++) {
            System.out.println("Enter food name: ");
            dummyVegetables[index] = scanner.next();
            System.out.println("Enter day: ");
            dummyDay[index] = scanner.nextInt();
            System.out.println("Enter month: ");
            dummyMonth[index] = scanner.nextInt();
            System.out.println("Enter year: ");
            dummyYear[index] = scanner.nextInt();
            LocalDate today = LocalDate.now();
            LocalDate endDate = LocalDate.of(dummyYear[index], dummyMonth[index], dummyDay[index]);
            dummyDaysLeft[index] = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate);

        }
        vegetables = dummyVegetables;
        day = dummyDay;
        month = dummyMonth;
        year = dummyYear;
        daysLeftArray = dummyDaysLeft;
    }

    protected void initializeTimeDifferenceArray() {
        for (int index = 0; index < arraySize; index++) {
            LocalDate today = LocalDate.now();
            LocalDate endDate = LocalDate.of(getYear()[index], getMonth()[index], getDay()[index]);
            getDaysLeft()[index] = (int) java.time.temporal.ChronoUnit.DAYS.between(today, endDate);
        }
    }

    //overall loop
    protected void menuLoop() {
        setArraySize(3);
        setVegetables(new String[]{readFood()});
        do {
            if (getMenuStatus() == 0) {  //default menu
                defaultMenu();
            } else if (getMenuStatus() == 1) {   //display fridge contents
                printFridge();
                setMenuStatus(0);
            } else if (getMenuStatus() == 2) { //update fridge contents
                updateFridge();
                printFridge();
                setMenuStatus(0);
            } else {
                System.out.println("OUT OF BOUNDS");
                setMenuStatus(0);
            }
        } while (getMenuStatus() != -1);
        writeFoodArray();
    }


    //file manipulation

    //creating + checking for food.txt - for food strings
    protected void createFoodMem(String message) {
        File myFile = new File(message + ".txt");
        try {
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println(message + " file exists");
            }
        } catch (IOException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }
    }


    protected void readFoodMem() {
        int noOfVeg = 0;
        String vegetable;

        try {
            myFileName = new FileReader("Fridge.txt");
            readMyFile = new Scanner(myFileName);
        } catch (FileNotFoundException error) {
            System.out.println("Cannot open file");
        }

        try {
            if (readMyFile.hasNext()) {
                noOfVeg = readMyFile.nextInt();
                System.out.println("Number of veg: " + noOfVeg);
            }
        } catch (Exception error) {
            System.out.println("Problem reading number of rows");
            System.out.println(error.getMessage());
            return;
        }

        try {
            while (noOfVeg != 0) {
                for (int index = 0; index < noOfVeg; index++) {
                    vegetable = readMyFile.nextLine();
                    System.out.println("Veg = " + vegetable);
                }
                noOfVeg = readMyFile.nextInt();
            }
            System.out.println("End of file");
        } catch (Exception error) {
            System.out.println(error.getMessage());

        }
    }

    protected void setArray() {
        arraySize = 0;
        try {
            myFileName = new FileReader("Food.txt");
            readMyFile = new Scanner(myFileName);
            while (readMyFile.hasNextLine()) {
                String data = readMyFile.nextLine();
                data = data.trim();
                if (!data.trim().isEmpty()) {
                    arraySize++;
                }
            }
        } catch (Exception error) {
            System.out.println("Error");
        }
        System.out.println("Array size succesfully set to " + (arraySize));
        System.out.println("--------------------------------------------");
        vegetables = new String[arraySize];
        day = new int[arraySize];
        month = new int[arraySize];
        year = new int[arraySize];
        daysLeftArray = new int[arraySize];
    }

    protected String readFood() {
            try {
                myFileName = new FileReader("Food.txt");
                readMyFile = new Scanner(myFileName);

            } catch (FileNotFoundException error) {
                System.out.println("Cannot open file");
            }

            try {
                for (int index = 0; index < arraySize; index++) {
                    vegetables[index] = readMyFile.nextLine();
                }
                readMyFile.close();
            } catch (Exception error) {
                System.out.println("An error occured .");
                error.printStackTrace();
            }
            return null;
    }

    protected void writeFoodArray() {
        boolean open;
        String myFileName = "Food.txt";

        try {
            myOutFile = new PrintWriter(myFileName);
            open = true;
        }
        catch (FileNotFoundException error) {
            System.out.println("Error opening the file");
            open = false;
        }

        try {
            if (open) {
                for (int index = 0; index < vegetables.length; index++) {
                    myOutFile.println(vegetables[index]);
                }
                myOutFile.println();
                myOutFile.close();
                open = false;
                System.out.println("Successfully written to file and closed");
            }
        } catch (Exception error) {
            System.out.println("Exception " + error.getMessage() + " caught");
        }
    }

    protected void writeFoodString() {
        boolean open;
        String [] vegetables = {"Courgette", "Carrots", "Broccoli" };
        String myFileName = "Food.txt";

        try {
            myOutFile = new PrintWriter(myFileName);
            open = true;
        }
        catch (FileNotFoundException error) {
            System.out.println("Error opening the file");
            open = false;
        }

        try {
            if (open) {
                for (int index = 0; index < vegetables.length; index++) {
                    myOutFile.print(vegetables[index] + " \n");
                }
                myOutFile.println();
                myOutFile.close();
                open = false;
                System.out.println("Successfully written to file and closed");
            }
        } catch (Exception error) {
            System.out.println("Exception " + error.getMessage() + " caught");
        }
    }

    //methods for reading in year,month,day

    protected void readInt(String message) {
        try {
            myFileName = new FileReader(message + ".txt");
            readMyFile = new Scanner(myFileName);
        } catch (FileNotFoundException error) {
            System.out.println("Cannot open file");
        }

        if (message.equalsIgnoreCase("day")) {
            try {
                for (int index = 0; index < arraySize; index++) {
                    day[index] = readMyFile.nextInt();
                }
                readMyFile.close();
            } catch (Exception error) {
                System.out.println("An error occured .");
                error.printStackTrace();
            }
        } else if (message.equalsIgnoreCase("month")) {
            try {
                for (int index = 0; index < arraySize; index++) {
                    month[index] = readMyFile.nextInt();
                }
                readMyFile.close();
            } catch (Exception error) {
                System.out.println("An error occured .");
                error.printStackTrace();
            }
        } else if (message.equalsIgnoreCase("year")) {
            try {
                for (int index = 0; index < arraySize; index++) {
                    year[index] = readMyFile.nextInt();
                }
                readMyFile.close();
            } catch (Exception error) {
                System.out.println("An error occured .");
                error.printStackTrace();
            }
        } else {
            System.out.println("Please select day, month, or year.");
        }
    }

    protected void writeInts(String message) {
        boolean open;
        String myFileName = message + ".txt";

        try {
            myOutFile = new PrintWriter(myFileName);
            open = true;
        }
        catch (FileNotFoundException error) {
            System.out.println("Error opening the file");
            open = false;
        }

        int [] integers = new int[arraySize];

        if (message.equalsIgnoreCase("day")) {
            integers = day;
        } else if (message.equalsIgnoreCase("month")) {
            integers = month;
        } else if  (message.equalsIgnoreCase("year")) {
            integers = year;
        }

        try {
            if (open) {
                for (int index = 0; index < integers.length; index++) {
                    myOutFile.println(integers[index]);
                }
                myOutFile.println();
                myOutFile.close();
                open = false;
                System.out.println("Successfully written to file and closed");
            }
        } catch (Exception error) {
            System.out.println("Exception " + error.getMessage() + " caught");
        }
    }
}
