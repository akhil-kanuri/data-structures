import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    //first variable refers to first node in the list
    // if the node is empty first will be null
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
        this.first = null;
    }

    public Integer size() {
        int size = 0;
        for (int i = 0; i <= this.first.length(); i++) {
            size += 1;
        }
        return size;
    }
    public Integer size2() {
        int size2 = 0;
        if (this.first.hasNext()) {
            size2 = size2 + 1;
            size2();
        }
        return size2;
    }

    public boolean contains(Object obj) {
        for (int i = 0; i <= this.first.length(); i++) {
            if (i == obj) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public boolean contains2(Object obj) {
        //
    }
    
    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst() {
        if (this.first == null){
            throw new NoSuchElementException();
        }
        return this.first.data;
    }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst() {
        if (this.first == null){
            throw new NoSuchElementException();
        }
        
        Object element = this.first.data;
        this.first = this.first.next;
        return element;
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = this.first; 
        this.first = newNode; 
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    //Class Node
    //node is a static class because it doesn't need to acsess 
    // anything in the Linked List
    static class Node {
        public Object data;
        public Node next;
        
    }

    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;
        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public ListIterator listIterator() {
            return new LinkedListIterator();
        }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            previous = position;
            isAfterNext = true; 

            if (position == null) {
                position = first;
            }
            else {
                position = position.next;
            }

            return position.data;
        }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext() {
            //check to see if the list is empty
            if (position == null) {
                return first != null;
            }
            return position.next != null;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element) {
            //check if the iterator is at the beginning
            if (position == null) {
                addFirst(element);
                position = first;
            }
            else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                //set the next element of the Current position
                //to point to the next node
                position.next = newNode; 
                position = newNode;
            }

            isAfterNext = false;
        }





        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }

            //check if iterator is at the beginning
            if (position == first) {
                removeFirst();
                position = null;
            }
            else {
                previous.next = position.next;
                position = previous;
            }
            isAfterNext = false;
        }






        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            position.data = element;
        }



    }//LinkedListIterator
}//LinkedList
