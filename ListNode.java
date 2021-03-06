package lab06;

import java.util.*;
import java.io.*;
import java.util.LinkedList;
public class ListNode<T> {
	static class Node <T>{
		T value;
		Node<T> next;
		Node<T> prev;

		Node(T value){
			this.value = value;
		}
	}
	
	Node<T> head = new Node<T>(null);
	Node<T> tail = head;
	int size;
	

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param item element to be appended to this list
     * @return {@code true}
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    public boolean add(Object item) throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException{
    	if(item == null)
    		throw new NullPointerException();
    	tail = tail.next = new Node(item); 
    	size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param position   index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */
    public void add(int position, Object item) throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException  {
    	
    	Node<T> node = head;
    	

    	while (position > 0) {
            node = node.next;
            position--;
        }
    	
    	Node<T> newNode = new Node(item);

        // Making the new Node to point to
        // the old Node at the same position
        newNode.next = node.next;

        // Replacing current with new Node
        // to the old Node to point to the new Node
        node.next = newNode;
    	
    	
    	
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param item element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     */
    public boolean contains(Object item) throws ClassCastException, NullPointerException{
    	//if (this.data == item)
    	Node<T> node = head.next;
    	while(node.next!=null) {
    		if(node.value == item) {
    	    	System.out.println("True");

    			return true;
    		}
    		else
    			node = node.next;
    	
    	}
    	return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param position index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    public Object get(int position) throws IndexOutOfBoundsException{
    	Node<T> node = head.next;
    	while(position>0) {
    	node = node.next;
    	position--;
    	}
    	System.out.println(node.value);
        return true;
    }

    /**
     * Removes the last element in this list. Returns the element that was removed from the
     * list.
     *
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public Object removeLast() throws IndexOutOfBoundsException{
        
    	Node<T> test = head;
        int count = 0;
    	while(test.next != null) {
    		test = test.next;
    		count++;
    	}
    	
    	if(count == 1)
    		throw new IndexOutOfBoundsException();
    		    	
    	Node<T> node = head;

        while (node.next.next != null)
            node = node.next;
 
        // Change next of second last
        node.next = null;
    	System.out.println(node.value);
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param item element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     */
    public boolean remove(Object item) throws ClassCastException, NullPointerException {
    	Node<T> node = head;
    	Node<T> temp = node;

        while (node.value != item) 
            node = node.next;
       
        // Change next of second last
        temp = node.next.next;
        node.next = null;
        node.next = temp;
   
        return true;
    }

    /**
     * Removes the element at the specified position from the end of the list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the head of the list.
     *
     * @param position the index of the item the end of the list to be removed
     * @return the head of the list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public ListNode removeFromEnd(int position) throws IndexOutOfBoundsException{
    	
        Node<T> node = head;
        int count = 0;
    	while(node.next != null) {
    		node = node.next;
    		count++;
    	}
    	
    	if(position > --count)
    		throw new IndexOutOfBoundsException();
            	    	 
    	if (head == null)
            return new ListNode();
 
        // Store head node
        Node<T> temp = head;
 
        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return new ListNode<>();
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position;
             i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return new ListNode<>();
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;
        return new ListNode<>();
    }

    /**
     * Shows ListNode as a String, with each object in parentheses separated by ???arrows??? (->).
     * A ListNode of {1, 2, 3} should return the String "(1) -> (2) -> (3)".
     * @return String representation of the ListNode
     */
    @Override
    public String toString() {
    	String result = "";
        Node<T> node = head.next;
        while(node.next != null){
            result += node.value;
            if(node.next.value != null){
                 result += ")->(";
            }
            node = node.next;
        }
        return "[(" + result + node.value +")]";
    }

    


public static void main(String[] args){
	ListNode<Integer> lst = new ListNode<>();
	System.out.println("adding values of 1-6 into list");
	lst.add(1);
	lst.add(2);
	lst.add(4);
	lst.add(5);
	lst.add(6);
	System.out.println(lst.toString());
	System.out.println("adding 3 into index of 2");
	lst.add(2,3);
	System.out.println(lst.toString());
	System.out.print("checking if list contains 3: ");
	lst.contains(3);
	System.out.print("Using the get method to obtain value of index 2: ");
	lst.get(2);
	System.out.println("Removing value of 3 from index of 2");
	lst.remove(2);
	System.out.println("New list:" + lst.toString());

}
}