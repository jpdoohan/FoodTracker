package VegetableFridge;

import java.util.Scanner;

public class Menu {
    //Scanner
    static Scanner keyboard = new Scanner(System.in);

    //variables
    private int menuStatus;

    //constructor

    public Menu() {
        menuStatus = 0;
    }

    public Menu(int pMenuStatus) {
        menuStatus = pMenuStatus;
    }

    //accessors/mutators
    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int pMenuStatus) {
        menuStatus = pMenuStatus;
    }

    //menu display
    public void displayMenu() {
        System.out.println("-----------------------");
        System.out.println("\tVeg Fridge Home");
        System.out.println("Enter:" +
                         "\nTo end program:         \t-1");
        System.out.println("To display fridge contents:\t1");
        System.out.println("To update fridge contents: \t2");
        System.out.println("-----------------------");
    }

    //getInt
    protected int getInt() {
        return keyboard.nextInt();
    }

    //overall loop
    protected void menuLoop() {
            do {
                displayMenu();
                setMenuStatus(getInt());
            } while (menuStatus != -1);
    }

    protected String getText(String message) {
        System.out.println(message);
        return keyboard.nextLine();
    }


}
