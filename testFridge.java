package fridge;

public class testFridge {
    public static void main(String[] args) {

        fridge fridge = new fridge(); //new fridge object

        fridge.setArray(); //initialise array by counting lines

        //check if files exist-and create them if they don't
        fridge.createFoodMem("Food");
        fridge.createFoodMem("Day");
        fridge.createFoodMem("Month");
        fridge.createFoodMem("Year");

        //populate arrays with strings and ints from food.txt
        fridge.readFood();
        fridge.readInt("Day");
        fridge.readInt("Month");
        fridge.readInt("Year");

        //populate time difference array
        fridge.initializeTimeDifferenceArray();

        //main menu loop
        do {
            if (fridge.getMenuStatus() == 0) {  //default menu
                fridge.defaultMenu();
            } else if (fridge.getMenuStatus() == 1) {   //display fridge contents
                fridge.printFridge();
                fridge.setMenuStatus(0);
            } else if (fridge.getMenuStatus() == 2) { //update fridge contents
                fridge.updateFridge();
                fridge.setMenuStatus(0);
            } else {
                System.out.println("OUT OF BOUNDS"); //error handling
                fridge.setMenuStatus(0);
            }
        } while (fridge.getMenuStatus() != -1); //terminator

        //save arrays for next time
        fridge.writeFoodArray();
        fridge.writeInts("Day");
        fridge.writeInts("Month");
        fridge.writeInts("Year");
    }
}
