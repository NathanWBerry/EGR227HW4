import java.util.*;

/**
 * Nathan Berry
 * EGR227 HW4 Pt 2
 */
public class Anagrams {
    private List<String> orderedDictionary;
    private Map<String, LetterInventory> inventoryMap;

    //Implement this class
    public Anagrams(List<String> dictionary) {
        orderedDictionary = new LinkedList<>(dictionary); //Initializes the dictionary in a LinkedList
        inventoryMap = new HashMap<>(); //Using a map prevents re-creation
        for(String s : dictionary) { //for each loop to iterate through the dictionary
            inventoryMap.put(s, new LetterInventory(s)); //Creates the letter inventory
        }
    }
    //This method prints out the Anagrams according to the given text and maximum words
    public void print(String text, int max) {
        explore(new LetterInventory(text), new LinkedList<String>(),
                pruneDictionary(text), max);
    }

    //This method prunes the dictionary by subtracting the elements in the map from the inventory
    private List<String> pruneDictionary(String text) {
        List<String> prunedDictionary = new LinkedList<>();
        LetterInventory textInventory = new LetterInventory(text);
        for (String s : orderedDictionary) {
            if(textInventory.subtract(inventoryMap.get(s)) != null) {
                prunedDictionary.add(s);
            }
        }
        return prunedDictionary;
    }
    //This method explores the remaining inventories using recursion
    private void explore(LetterInventory inventoriesLeft, List<String> chosen,
                         List<String> prunedDictionary, int max) {
        if (inventoriesLeft.isEmpty()) {
            System.out.println(chosen); //Prints out the chosen List when there are no more remaining inventories
        } else if (max == 0 || chosen.size() < max) { //Won't run if the size is larger than the max
            for (String s : prunedDictionary) { //Runs through the whole pruned dictionary
                LetterInventory newInventoriesLeft = inventoriesLeft.subtract(inventoryMap.get(s));
                if (newInventoriesLeft != null) { //If there are still inventories left
                    chosen.add(s);
                    explore(newInventoriesLeft, chosen, prunedDictionary, max); //Recursive call
                    chosen.remove(chosen.size()-1); //Removes the chosen that was just explored
                }
            }
        }
    }
}
