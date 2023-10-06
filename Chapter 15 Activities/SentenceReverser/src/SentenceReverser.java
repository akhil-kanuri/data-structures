import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
    	String reversed = "";
        Stack<String> words = new Stack<>();

        while(scanner.hasNext())
        {
            String next = scanner.next();
            if(next.contains("."))
            {
                reversed = reversed + next.substring(0,1).toUpperCase() + next.substring(1,next.length()-1) + " ";
                int stackSize = words.size();
                for(int i = 0; i < stackSize-1; i++)
                {
                    reversed += words.pop() + " ";
                }
                reversed += words.pop().toLowerCase() + ". ";
            }
            else
            {
                words.push(next);
            }
        }

        return reversed;
    }
}
