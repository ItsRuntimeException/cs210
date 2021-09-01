import java.util.TreeMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class Dictionary
{
    public static void main(String[] args)
    {
        String key, value;
        TreeMap dictionary = new TreeMap();

        System.out.println("Words That Are Already In The Dictioinary:");
        key = "Fish(es)"; value = "An animal that makes bubbles in water.";
        dictionary.put(key, value);
        key = "Dog(s)";  value = "An animal that barks, and loves human.";
        dictionary.put(key, value);
        printMap(dictionary);

        Scanner console = new Scanner(System.in);
        System.out.print("Add Your Own Word To The Dictionary:\n");
        System.out.print("key - ");
        key = console.nextLine();
        System.out.print("def - ");
        value = console.nextLine();
        value = value.substring(0,1).toUpperCase() + value.substring(1);
        System.out.println();
        dictionary.put(key, value);

        // print the whole dictionary
        printMap(dictionary);

        // find and print a desired word in the dictionary : !found = null
        System.out.print("Find A Word That IS In The Dictionary:\n");
        System.out.print("key - ");
        key = console.nextLine();
        System.out.println("def - " + dictionary.get(key) + "\n");

        System.out.print("Enter A Word That Is NOT In The Dictionary:\n");
        System.out.print("key - ");
        key = console.nextLine();
        System.out.println("def - " + dictionary.get(key) + "\n");

        // delete a key-pair
        System.out.print("DELETE A Word That Is In The Dictionary:\n");
        System.out.print("key - ");
        key = console.nextLine();
        dictionary.remove(key);

        // Find the deleted key-pair
        System.out.println("\n*FINDING THE DELETED KEY...\n");
        System.out.print("System Found: " + dictionary.get(key) + "\n");
        System.out.print("Dictionary Now ONLY Contain(s):\n");
        printMap(dictionary);
    }

    static void printMap(TreeMap dictionary)
    {
        Set dictionarySet = dictionary.entrySet();
        Iterator i = dictionarySet.iterator();

        while (i.hasNext())
        {
            Map.Entry self = (Map.Entry)i.next();
            System.out.print(self.getKey() + ": ");
            System.out.println(self.getValue());
        }
        System.out.println();
    }
}
