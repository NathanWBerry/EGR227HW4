import java.util.*;
import java.lang.reflect.*;

/**
 * Nathan Berry
 * EGR227 HW4
 */
public class LetterInventory {
    //Implement this class
    public final int COUNTER = 26;
    public int total;
    private int[] inventory;

    public LetterInventory() {
        inventory = new int[COUNTER];
        for (int i = 0; i < COUNTER; i++) {
            inventory[i] = 0;
        }
        total = 0;
    }

    public LetterInventory(String data) {
        // Initialize the array
        this();
        // This loop goes through the string characters to get the total number of counters
        for(int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            //This if statement ignores all characters other than letters
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                //Calls helper method to easily get index numbers for each character
                inventory[getIndex(c)]++;
                total++;
            }
        }
    }


    public int get(char letter) { //Gets the count for the character entered
        if (!Character.isLetter(letter)) throw new IllegalArgumentException("Must be letters.");
        return inventory[getIndex(letter)];
    }

    private static int getIndex(char letter) { //Helper method that converts a char into its index in the array
        letter = Character.toLowerCase(letter);
        return (int)letter - (int)'a';
    }

    public void set(char letter, int value) { //This method sets a new value or count to a given char
        //Throws an error if the char is not a letter or the value is negative
        if (!Character.isLetter(letter)) throw new IllegalArgumentException("Must be a letter to call this method.");
        if (value < 0) throw new IllegalArgumentException("Can't input negative numbers.");

        total += value - inventory[getIndex(letter)]; //Sets the new total count
        inventory[getIndex(letter)] = value; //Sets the new value to the char
    }

    public int size() { //this method returns the total amount of counts in the array
        return total;
    }

    public boolean isEmpty() { //returns true if the array is empty
        if (total == 0) return true;
        else return false;
    }

    public String toString() { //Converts the array to a string
        String answer = "[";
        for (int i = 0; i < COUNTER; i++) { //Loops through all 26 indexes
            for (int j = 0; j < inventory[i]; j++) {
                answer += (char)('a' + i); //Converts the index back into characters
            }
        }
        answer += "]";
        return answer;
    }

    public LetterInventory add(LetterInventory other) { //This method adds the counts of two different LetterInventories together
        LetterInventory newInventory = new LetterInventory();
        for (int i = 0; i < COUNTER; i++) {
            newInventory.inventory[i] = inventory[i] + other.inventory[i]; //Adds the counts
        }
        newInventory.total = total + other.total; //Adds the total counts
        return newInventory;
    }

    public LetterInventory subtract(LetterInventory other) { //This method subtracts an inventor
        LetterInventory newInventory = new LetterInventory();
        for (int i = 0; i < COUNTER; i++) {
            if (inventory[i] - other.inventory[i] < 0) {
                return null;
            } else {
                newInventory.inventory[i] = inventory[i] - other.inventory[i];
            }
        }
        newInventory.total = total - other.total;
        return newInventory;
    }

    public double getLetterPercentage(char letter) {
        double answer = get(letter) / (double)total;
        return answer;
    }

}
