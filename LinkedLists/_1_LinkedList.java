/**
 * 
 * @author Samanvitha Basole
 * LinkedList operations
 */
public class _1_LinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.prepend(3);
		list.prepend(5);
		list.prepend(7);
		list.prepend(11);
		list.prepend(13);
		list.prepend(15);
		list.append(8);
		list.deleteAt(11);
		list.deleteAfter(7);
		list.deleteBefore(7);
		list.insertAfter(7, 5);
		list.printList();
		
	
	}
}

class Node {
	public int data;
	public Node next;
	public Node (int d) {
		data = d;
	}
	public void display() {
		System.out.println("Data: " + data);
	}
}

class LinkedList {
	
	private Node first;
	
	public LinkedList() {
		first = null;
	}
	
	/*
	 * isEmpty checks if the linked list is empty
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/*
	 * prepend inserts a node at the beginning of the linkedlist
	 */
	public void prepend(int d) {
		Node newNode = new Node(d);
		newNode.next = first;
		first = newNode; 
	}
	
	/*
	 * deleteFirst removes the first or head node in a linkedList
	 * typically the one recently added
	 */
	public Node deleteFirst() {
		Node tmp = first;
		if (first == null) {
			return null;
		}
		first = first.next;
		return tmp;
	}
	
	/*
	 * printList prints the entire list by starting from the one just added to the end of the list
	 */
	public void printList() {
		Node current = first;
		if (isEmpty()) {
			System.out.println("LinkedList is empty!");
		}
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
	
	/*
	 * Insert node with value e after node with value d
	 */
	public void insertAfter(int d, int e) {
		Node newNode = new Node(e);
		Node current = first;
		if (current == null) {
			current = newNode;
		}
		else {
			while (current.data != d) {
				current = current.next;
			}
			Node newpointer = current.next;
			current.next = newNode;
			newNode.next = newpointer;
		}
	}
	
	/*
	 * Insert node before a given value
	 */
	public void insertBefore(int d) {
		
	}
	
	/*
	 * Replace a node at a given value
	 */
	
	/*
	 * append inserts an element at the end of the linkedlist
	 */
	public void append(int d) {
		Node newNode = new Node(d);
		Node current = first;
		if (current == null) {
			first = newNode;
		}
		else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = null;
		}
	}
	
	/*
	 * deleteLast deletes the last node or the first node that was added to the linkedlist
	 */
	public Node deleteLast() {
		Node current = first;
		while (current.next.next != null) {
			current = current.next;
		}
		Node toRemove = current.next;
		current.next = null;
		return toRemove;
	}
	
	/*
	 * deleteAt deletes the node with the given data
	 */
	public Node deleteAt(int d) {
		Node current = first;
		if (current == null) {
			return null;
		}
		else {
			while (current.next.data != d) {
				current = current.next;
			}
			Node toRemove = current.next;
			current.next = current.next.next;
			return toRemove;
		}
	}
	
	/*
	 * deleteAfter deletes the node after a given value
	 */
	public Node deleteAfter(int d) {
		Node current = first;
		if (current == null) {
			return null;
		}
		else {
			while (current.data != d) {
				current = current.next;
			}
			Node toRemove = current.next;
			current.next = current.next.next;
			return toRemove;
		}
	}
	
	/*
	 * deleteBefore deletes the node before a given value
	 */
	public Node deleteBefore(int d) {
		Node current = first;
		if (current == null) {
			return null;
		}
		else if (current.next == null) {
			return null;
		}
		else {
			while (current.next.next.data != d) {
				current = current.next;
			}
			Node toRemove = current.next;
			current.next = current.next.next;
			return toRemove;
		}
	}
	
}