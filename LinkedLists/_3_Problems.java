import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class _3_Problems {
	public static void main(String[] args) {
		LinkedList3 list = new LinkedList3();
		LinkedList3 list2 = new LinkedList3();
		list.prepend(15);
		list.prepend(12);
		list.prepend(11);
		list.prepend(10);
		list.prepend(6);
		list.prepend(4);
	
		
		list2.append(1);
		list2.append(2);
		list2.append(3);
		list2.append(5);
		list2.append(7);
		list2.append(8);
		list2.append(9);
		
		/*
		System.out.println(list.isPalindrome());
		list.printList();
		list.removeDuplicatesFromSorted();
		System.out.println("After deleting duplicates");
		list.printList();
		*/
		list.printList();
		System.out.println("------------------");
		list2.printList();
		System.out.print("Intersection node is: " + list.intersectionOfTwoLists(list2));
		System.out.println("\nLoop detected: " + list.detectLoop());
		System.out.println("------------------");
		list.mergeSorted(list2);
		list.printList();
		
		System.out.println("------------------");
		list.makeMiddleFirst();
		list.printList();
	
		System.out.println("------------------");
		list.insertFromEnd(33, 3);
		list.printList();
		/**
		System.out.println("------------------");
		list.deleteMiddle();
		list.printList();
		System.out.println("------------------");
		list.deleteMiddle();
		list.printList();
	**/
		System.out.println("remove from unsorted------------------");
		list.prepend(4);
		list.prepend(6);
		list.prepend(12);
		list.printList();
		list.removeDuplicatesFromUnsorted();
		System.out.println("------------------");
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
	
	public void removeDuplicatesFromUnsorted() {
		//brute-force - two nested loops, pick one and check the entire LL for that element then delete
		//another approach - sort but elements not in order, nlogn complexity
		//use a set
		Set<Node> set = new HashSet<>();
		Node current = first;
		Node previous = first;
		while (current.next != null) {
			if (!set.contains(current)) {
				set.add(current);
				previous = current;
				current = current.next;
			}
			else {
				previous.next = current.next;
			}
		}
	}
	
	public Node intersectionOfTwoLists(LinkedList3 list2) {
		
		for (Node current = first; current.next != null; current = current.next) {
			for (Node curr = list2.first; curr.next != null; curr = curr.next) {
				if (current.data == curr.data) { //should compare address not contents
					return current;
				}
			}
		}
		return null;
	}
	
	public boolean detectLoop() {
		HashSet<Integer> set = new HashSet<Integer>();
		Node current = first;
		while (current.next != null) {
			if (set.contains(current.data)) {
				return true;
			}
			set.add(current.data);
			current = current.next;
		}
		return false;
	}
	
	public void mergeSorted(LinkedList3 anotherList) {
		Node ptr = null;
		Node curr1 = first;
		Node curr2 = anotherList.first;
		
		if (curr2.data < curr1.data) {
			ptr = curr2;
			curr2 = curr2.next;
			ptr.next = curr1;
			curr1 = ptr;
			first = ptr;
		}

		while (curr1 != null && curr2 != null) {
			if (curr1.data < curr2.data) {
				ptr = curr1;
				curr1 = curr1.next;
			}
			else {
				Node tmp = curr2.next;
				this.insertAfter(ptr.data, curr2.data);
				ptr = ptr.next;
				curr2 = tmp;
			}
		}
		if (curr1.next == null && curr2.next != null) {
			while (curr2.next != null) {
				this.insertAfter(curr2.data, curr2.data);
				curr2 = curr2.next;
			}
		}
	}
	
	public void makeMiddleFirst() {
		Node curr = first;
		Node fast = first;
		fast = fast.next.next;
		while (fast.next != null) {
			fast = fast.next.next;
			curr = curr.next;
		}
		Node middle = curr.next;
		curr.next = curr.next.next;
		middle.next = first;
		first = middle;
	}
	
	public void insertFromEnd(int x, int n) {
		Node curr = first;
		Node fast = first;
		for (int i = 1; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			curr = curr.next;
		}
		insertAfter(curr.data, x);
	}
	
	public void deleteMiddle() {
		Node slow = first;
		Node fast = first;
		fast = fast.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println(fast.data);
		}
		slow.next = slow.next.next;
	}
}
