import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /*the addLast method can populate a list */
        LinkedList <String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");
        /*The list is currently TNPG */
        /*
         * The list oterator methed creates a new list iterator that
         * is positioned at the head. 
         * the "|" is to represent the position.
         */
        ListIterator<String> iterator = staff.listIterator(); // |TNPG
        // the next method advances the iterator over the next element in the list. 
        iterator.next(); // T|NPG
        /*The next method also returns the next element that the iterator is passing */
        String avenger = iterator.next(); //TN|PG
        System.out.println(avenger);
        System.out.println("Expected: Natasha");

        /* the add method inserts an element at the iterator position
         * the iterator is then positioned AFTER the element that was added
         */
        iterator.add("Bruce");//TNB|PG
        iterator.add("Rocket");//TNBR|PG

        /* the remove method removes the element returned by the last called
         * to next or previous
         * The remove method can only be called after next or previous
         * The remove method cannot be called after calling add
         */

        iterator.next();//TNBRP|G
        iterator.remove();//TNBR|G

        System.out.println(staff);
        System.out.println("Expected: [T,N,B,R,G]");

        /* The set method updates the element returned by the last call to next or previous.
         * 
         */

        iterator.previous();// TNB|RG
        iterator.set("Scott"); //TNBSG

        /*The has next method is used to determine if there is a
         next node after the iterator.  
         The has next method is often used in the condition of a while loop*/

        iterator = staff.listIterator();//|TNBSG
        while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")) { // TN|BSG
                iterator.remove(); //T|BSG
            }
        } // TBSG|

        /* enhanced for loops work with linked lists! */
        for (String n: staff) {
            System.out.println(n+ " ");

        }
        System.out.println();
        System.out.println("Expected: Tony Bruce Scott Gamora");
        /*
         * ConcurrentModificationException
         * 
         */

        iterator = staff.listIterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Scott")) {
                staff.remove("Scott"); 
            }
        }
        System.out.println(staff);  
        //enhanced for loop automatically creates an iterator
        for (String n: staff) {
            if (n.equals("Scott")) {
                staff.add("Rocket");
            }
        }



    }
}
