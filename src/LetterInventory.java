import java.util.*;
import java.lang.reflect.*;

/**
 * Write your comments here
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

    private int inventoryHelper(char[] data, char c) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                count++;
            }
        }
        return count;
    }

    public LetterInventory(String data) {
        /* Setup array */
        this();
        /* Iterate over the input String to allocate the appropriate counters */
        for(int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            /* Consider only letter characters */
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                /* convenient way to get indices from character values */
                inventory[getIndex(c)]++;
                total++;
            }
        }
    }


    public int get(char letter) {
        if (!Character.isLetter(letter)) throw new IllegalArgumentException("Must be letters.");
        return inventory[getIndex(letter)];
    }

    private static int getIndex(char letter) {
        letter = Character.toLowerCase(letter);
        return (int)letter - (int)'a';
    }

    public void set(char letter, int value) {

    }

    public int size() {
        return total;
    }

    public boolean isEmpty() {
        if (total == 0) return true;
        else return false;
    }

    public String toString() {
        return "";
    }

    public LetterInventory add(LetterInventory other) {
        return other;
    }

    public LetterInventory subtract(LetterInventory other) {
        return other;
    }

    public double getLetterPercentage(char letter) {
        return 0.0;
    }

}
