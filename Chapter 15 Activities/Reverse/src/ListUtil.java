import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        ListIterator<String> iterator2 = strings.listIterator();
        
         
        for (int k = 0; k < strings.size(); k++) {
            iterator2.next();
        }
        for (int i = 0; i < strings.size()/2; i++) {
            String name1 = iterator.next();
            String name2 = iterator2.previous();

            iterator.set(name2);
            iterator2.set(name1);
        }

    }
}