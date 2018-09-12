import java.util.HashSet;
import java.util.Set;

public class _4_Problems {
	public static void main(String[] args) {
		LinkedList4 list = new LinkedList4();
		list.prepend(15);
		list.prepend(12);
		list.prepend(10);
		list.prepend(15);
		list.prepend(10);
		list.prepend(4);
		
		System.out.println("remove from unsorted------------------");
		list.printList();
		list.removeDuplicatesFromUnsorted();
		System.out.println("------------------");
		list.printList();
		System.out.println("reverse------------------");
		list.printList();
		list.reverse();
		System.out.println("------------------");
		list.printList();
	}
}



class LinkedList4 extends LinkedList {
	
	public LinkedList4() {
		super();
	}
	
	public void removeDuplicatesFromUnsorted() {
		//brute-force - two nested loops, pick one and check the entire LL for that element then delete
		//another approach - sort but elements not in order, nlogn complexity
		//use a set
		HashSet<Integer> set = new HashSet<>();
		Node current = first;
		Node previous = first;
		while (current != null) {
			int d = current.data;
			if (!set.contains(d)) {
				set.add(d);
				previous = current;
				current = current.next;
			}
			else {
				previous.next = current.next;
				current = current.next;
			}
		}
	}
	
	public void reverse() {
		Node curr = first;
		Node prev = null;
		while (curr != null) {
			Node rest = curr.next;
			curr.next = prev;
			prev = curr;
			curr = rest;
		}
		first = prev;
	}
	
}
