/**
 * @author Samanvitha Basole
 * LinkedList basic problems
 */
public class _2_EasyProblems {
	
	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		list.prepend(1);
		list.prepend(2);
		list.prepend(3);
		list.prepend(4);
		list.prepend(5);
		list.prepend(6);
		//list.swapAfter(4);
		//list.printList();
		//list.deleteLinkedList();
		list.printList();
		//list.printMiddle();
		list.printNthFromEnd(5);
		System.out.println(list.occurrences(5));
		System.out.println(list.frequency(3));
		System.out.println("------------------------\nActual:");
		list.printList();
		System.out.println("------------------------\nReverse: ");
		System.out.println(list.printReverse());
	}
}
class LinkedList2 extends LinkedList {
	
	public LinkedList2() {
		super();
	}
	
	/*
	 * deleteLinkedList deletes a linkedlist
	 */
	public void deleteLinkedList() {
		first = null;
	}
	
	/*
	 * swap the node with the one after it
	 */
	public boolean swapAfter(int d) {
		if (first != null) {
			Node current = first;
			if (current.data == d) {
				// only one node exists
				if (current.next == null) {
					return false;
				}
				//two nodes exist
				else if (current.next.next == null) {
					Node tmp = current.next;
					current.next.next = current;
					first = tmp;
					first.next.next = null;
					return true;
				}
				//more than two nodes exist
				else { 
					Node tmp = current.next;
					current.next = current.next.next;
					tmp.next = current;
					first = tmp;
					return true;
				}
			}
			while (current.next.data != d) {
				current = current.next;
			} 
			if (current.next != null && current.next.next != null) {
				Node tmp = current.next.next;
				current.next.next = current.next.next.next;
				tmp.next = current.next;
				current.next = tmp;
				return true;
			}
		}
		return false;
	}
	
	/*
	 * swap the given node with the one before it
	 */
	public boolean swapBefore(int d) {
		return false;
	}
	
	/*
	 * given two keys, swap nodes without swapping data
	 * https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
	 */
	public void swap(int a, int b) {
		Node x = first;
		Node y = first;
		while (x.next.data != a) {
			x = x.next;
		}
		Node a_node = x.next;
		while (y.next.data != b) {
			y = y.next;
		}
		Node b_node = y.next;
		
		Node point1 = x.next.next;
		Node point2 = y.next.next;
		
		b_node.next = point1;
		x.next = b_node;
		a_node.next = point2;
		y.next = a_node;
	}
	
	/*
	 * prints the middle node in a linkedlist
	 */
	public void printMiddle() {
		Node mid = first;
		Node end = first;
		while (end != null && end.next != null) {
			end = end.next.next;
			mid = mid.next;
		}
		mid.display();
	}
	
	/*
	 * prints the nth node from the end of the linkedlist
	 * naive approach - count length, len-n+1 formula
	 */
	public void printNthFromEnd(int n) {
		Node nth = first;
		Node end = first;
		for (int i = 0; i < n; i++) {
			end = end.next;
		}
		while (end != null) {
			end = end.next;
			nth = nth.next;
		}
		nth.display();
	}
	
	/*
	 * return the number of times an int occurs in a list
	 */
	public int occurrences(int d) {
		Node current = first;
		int count = 0;
		while (current != null) {
			if (current.data == d) {
				count += 1;
			}
			current = current.next;
		}
		return count;
	}
	
	public int frequency(int d) {
		return frequency(d, first);
	}
	public int frequency(int d, Node n) {
		if (n == null) {
			return 0;
		}
		else if (n.data == d) {
			return 1 + frequency(d, n.next);
		}
		return frequency(d, n.next);
	}
	
	/*
	 * prints the reverse of a linkedlist without reversing it
	 */
	public String printReverse() {
		return printReverse(first);
	}
	public String printReverse(Node head) {
		if (head != null) {
			return printReverse(head.next) + head.toString() + "\n";
		}
		return null;
	}
	
	
	
}
