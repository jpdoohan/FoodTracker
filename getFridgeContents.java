package VegetableFridge;

import java.io.*;
import java.util.Scanner;

/**
 * This should work for grabbing info from a .txt doc into java,
 * yous can try it yourselves to pull in a load of strings.
 * I've included some instructions, but basically it'll ask you to input a file path,
 * which you can do by creating your .txt doc in whatever folder  you want,
 * right clicking it, and selecting copy as path. Then you paste that in but mind you,
 * you have to remove the "" from either side of it
 * i.e. "C:\Users\johnp\OneDrive - Ulster University\Com809\groupwork\fridgeOfVegetables.txt"
 * becomes
 * C:\Users\johnp\OneDrive - Ulster University\Com809\groupwork\fridgeOfVegetables.txt .
 * A bit clunky at the minute but at least it works- 
 * will work on using this now to get a first version of the thing working,
 * then after we have a prototype we can focus on user-friendliness - cheers!
 */

public class getFridgeContents {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================================");
        System.out.println("Enter file path for fridge (create .txt document if none exist).");
        System.out.println("i.e. C:\\Users\\johnp\\OneDrive - Ulster University\\Com809\\groupwork\\fridgeOfVegetables.txt");
        System.out.println("right click .txt, copy path, paste");
        System.out.println("Be sure to remove any \" ");
        String path = scanner.nextLine();
        File file = new File (path);
        Scanner keyboard = new Scanner(file);
        while (keyboard.hasNextLine()) {
            System.out.println(keyboard.nextLine());
        }
    }
}

