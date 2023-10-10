import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "C:\\Users\\famka\\OneDrive\\Desktop\\Software engineering\\data-structures\\Chapter 15 Activities\\StringLengthMap\\src\\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            Map<Integer, String> stringLength = new HashMap<>();
            

            while (in.hasNext())
            {
                String word = clean(in.next());
                System.out.println(word);
                Integer len = word.length();
               // System.out.println(word);
                // Update the map here
                // Modify Worked Example 15.1
                if (stringLength.get(len) != null)
                {
                    String existingWord = stringLength.get(len);
                    stringLength.put(len,existingWord+ ","+ word);

                }
                else {
                    stringLength.put(len, word);
                }


            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            for (int i = 0; i<= stringLength.size(); i++) {
                System.out.println(stringLength.get(i));
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
