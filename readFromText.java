package VegetableFridge;

import java.io.*;
import java.util.Scanner;

public class readFromText {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File ("C:\\Users\\psd24doj\\OneDrive - Ulster University\\Com809\\groupwork\\Hello world.txt");
        Scanner keyboard = new Scanner(file);
        while (keyboard.hasNextLine()) {
            System.out.println(keyboard.nextLine());
        }
    }
}
