package DoublyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.IPlaneList;


public class DoublyLinkedList<AnyType> {
    // Front, head node
    private ListNode<AnyType> front;
    // size.
    private int size;

    // for itertator
    private ArrayList<AnyType> list = new ArrayList<AnyType>();
    public DoublyLinkedList(ArrayList<AnyType> list) {
        this.list = list;
    }

    //Constructor
    public DoublyLinkedList() {
        front = null;
        size = 0;
    }
    public void addFront(AnyType x) {
        if(isEmpty())
            front = new ListNode <AnyType>(x);
        else {
            ListNode<AnyType> temp = front;
            front = new ListNode<AnyType>(null, x, temp);
            front.next.prev = front;
        }
        size++;
    }
    public void addEnd(AnyType x) {
        if(isEmpty())
            front = new ListNode<AnyType>(x);
        else {
            ListNode<AnyType> temp = front;
            // travel to the end of a list
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode<AnyType>(temp, x, null);
        }
        size++;

    }
    public void clear() {
        if(isEmpty() == false) {
            ListNode<AnyType> temp = front;
            while(temp.next != null) {
                temp = temp.next;
                temp.prev = null;
            }
            temp = null;
        }
        size = 0;
    }
    // param X is value to look for, param y is val to add
    public void addBefore(AnyType x, AnyType y) {
        if(isEmpty())
            throw new NoSuchElementException("Element " + x.toString() +" not found");

        ListNode<AnyType> current = front;

        //seeking
        while(current != null && !current.data.equals(x))
            current = current.next;
        // if null, haven`t found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() +" not found");

        ListNode<AnyType> newNode = new ListNode<AnyType>(current.prev, y, current);
        if(current.prev != null)
            current.prev.next = newNode;
        else
            front = newNode;
        current.prev = newNode;

        size++;
    }

    public boolean contains (AnyType x) {
        if(isEmpty())
            throw new NoSuchElementException("Element " + x.toString() +" not found");

        ListNode<AnyType> current = front;

        //seeking
        while(current != null && !current.data.equals(x))
            current = current.next;
        // if null, haven`t found
        if (current == null) {
            throw new NoSuchElementException("Element " + x.toString() +" not found");
        }
        else
            return true;
    }

    public Object[] toArrayy() {
    	/*
    	if(isEmpty(DoublyLinkedList))
    		throw new IllegalStateException("Collection is empty")
		else {
		*/
        Object[] objects = new Object[size] ;
        //objects = this.toArray();
        return objects;
			/*
			ListNode<AnyType> toArray(T[] a);
	    	ListNode<AnyType> current = front;

	    	while(current != null) {
	    		objects[count] = current.to
	    	}
	    	*/
    }

    public void addAfter(AnyType x, AnyType y) {
        if(isEmpty()) {
            throw new NoSuchElementException("Element " + x.toString() +" not found");
        }

        ListNode<AnyType> current = front;
        //seeking
        while(current != null && !current.data.equals(x))
            current = current.next;
        // if null, haven`t found
        if (current == null) {
            throw new NoSuchElementException("Element " + x.toString() +" not found");
        }

        //found
        ListNode<AnyType> newNode = new ListNode<AnyType>(current, y, current.next);
        if(current.next != null)
            current.next.prev = newNode;
        current.next = newNode;

        size++;

    }
    public void remove(AnyType x) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");
        // Removing front element
        if (front.data.equals(x)) {
            front = front.next;
            return;
        }
        ListNode<AnyType> current = front;
        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;
        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");
        // missing requiered object
        if (current.next != null)
            current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;
    }

    public String[] toStringg() {
        int count = 0;
        if(isEmpty())
            throw new RuntimeException(" empty ");

        ListNode<AnyType> current = front;
        String [] string_arr = new String[size];
        //seeking
        while(count < size) {
            string_arr[count] = current.toString();
            current = current.next;
            count++;
        }
        return string_arr;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    /*
	@Override
	public Iterator<AnyType> iterator() {

		return new DoublyLinkedListIterator<AnyType>(this);
	}
	*/



}
