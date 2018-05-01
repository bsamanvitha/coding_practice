
public class _3_Problems {
	public static void main(String[] args) {
		LinkedList3 list = new LinkedList3();
		list.prepend(1);
		list.prepend(2);
		list.prepend(3);
	}
}
class LinkedList3 extends LinkedList {
	
	public LinkedList3() {
		super();
	}
	
	/*
	 * deleteLinkedList deletes a linkedlist
	 */
	public void deleteLinkedList() {
		first = null;
	}
}
