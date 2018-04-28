/**
 * @author Samanvitha Basole
 * LinkedList basic problems
 */
public class _2_EasyProblems {
	
	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		list.prepend(2);
		list.prepend(4);
		list.prepend(6);
		list.prepend(8);
		list.prepend(10);
		list.prepend(12);
		list.prepend(14);
		list.prepend(16);
		list.swapAfter(4);
		list.printList();
		list.deleteLinkedList();
		list.printList();
		
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
	
}
