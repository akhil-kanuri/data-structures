import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // read dictionary and the novel
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/war-and-peace.txt");

        //print all the words that are in the novel but not the dictionary
        for (String word: novelWords) {
            if (!dictionaryWords.contains(word)) {
                System.out.println(word);
            }
        }
        //Print Number of unique words in the novel
        System.out.println("There are "+novelWords.size()+" unique words in the novel");

        //print the number of words greater than three letters
        Iterator<String> iterator = novelWords.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() > 3) {
                iterator.remove(); 
            }
        }

        System.out.println("There are "+novelWords.size()+" unique words with more than three letters in the novel");
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        //We need to use HashSet intead of tree cause order doesn't matter
        Set<String> words = new HashSet<>();

        //Determine the current working directory
        //System.out.println(System.getProperty("user.dir")); 

        Scanner in = new Scanner(new File(filename), "UTF-8");
        // Use any character that is not a letter as delimeters
        in.useDelimiter("[^a-zA-Z]+");

        while(in.hasNext()) {
            //add words to the set and by default duplicates are ignored
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}
