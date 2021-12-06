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

    public void print(String text, int max) {
        explore(new LetterInventory(text), new LinkedList<String>(),
                pruneDictionary(text), max);
    }

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

    private void explore(LetterInventory inventoriesLeft, List<String> chosen,
                         List<String> prunedDictionary, int max) {
        if (inventoriesLeft.isEmpty()) {
            System.out.println(chosen);
        } else if (max == 0 || chosen.size() < max) {
            for (String s : prunedDictionary) {
                LetterInventory newInventoriesLeft = inventoriesLeft.subtract(inventoryMap.get(s));
                if (newInventoriesLeft != null) {
                    chosen.add(s);
                    explore(newInventoriesLeft, chosen, prunedDictionary, max);
                    chosen.remove(chosen.size()-1);
                }
            }
        }
    }
}
