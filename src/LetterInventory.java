import java.util.*;
import java.lang.reflect.*;

/**
 * Write your comments here
 */
public class LetterInventory {
    //Implement this class
    public final int COUNTER = 26;

    public LetterInventory() {
        Integer[] inventory = new Integer[COUNTER];
        for (int i = 0; i < COUNTER; i++) {
            inventory[i] = 0;
        }
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
        StringBuilder observedCharacters = new StringBuilder();
        char[] dataArray = data.toCharArray();
        Arrays.sort(dataArray);

        Integer[] inventory = new Integer[dataArray.length];
        for (int i = 0; i < dataArray.length - 2; i++) {
            if (dataArray[i] == ' ' || dataArray[i] == '?' || dataArray[i] == '-' || dataArray[i] == '!') {
                dataArray[i] = dataArray[i + 1];
            }
            inventory[i] = inventoryHelper(dataArray, dataArray[i]);

        }
    }


    public int get(char letter) {
        return letter;
    }

    public void set(char letter, int value) {

    }

    public int size() {

        return 0;
    }

    public boolean isEmpty() {
        return false;
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
