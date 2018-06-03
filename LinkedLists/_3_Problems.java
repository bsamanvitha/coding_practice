import java.util.Stack;

public class _3_Problems {
	public static void main(String[] args) {
		LinkedList3 list = new LinkedList3();
		list.prepend(1);
		list.prepend(1);
		list.prepend(1);
		list.prepend(2);
		list.prepend(2);
		list.prepend(3);
		System.out.println(list.isPalindrome());
		list.printList();
		list.removeDuplicatesFromSorted();
		System.out.println("After deleting duplicates");
		list.printList();
	}
}
class LinkedList3 extends LinkedList {
	
	public LinkedList3() {
		super();
	}
	
	/*
	 * reverses a linkedlist
	 */
	public void reverseLL() {
		
	}
	
	public boolean isPalindrome() {
		// push to stack
		Stack<Node> s = new Stack<Node>();
		Node current = first;
		while (current != null) {
			s.push(current);
			current = current.next;
		}
		
		current = first;
		while (!s.isEmpty()) {
			Node toCompare = s.pop();
			if (toCompare.data != current.data) {
				System.out.println(current + " " + toCompare );
				return false;
			}
			current = current.next;
		}
		return true;
	}
	
	public void removeDuplicatesFromSorted() {
		Node current = first;
		while (current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			}
			else {
				current = current.next;
			}
		}
	}
}
