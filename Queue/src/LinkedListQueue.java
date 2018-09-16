
public class LinkedListQueue {
	private Node front;
	private Node last;
	public LinkedListQueue() {
		front = null;
		last = null;
	}
	public boolean isEmpty() {
		return front == null;
	}
	public void removeAll() {
		front = null;
	}
	public boolean enqueue(Node d) {
		if (front == null) {
			front = last = d;
		}
		else {
			last.next = d;
			last = d;
		}
		return true;
	}
	public Node dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty!");
		}
		Node d = front;
		front = front.next;
		return d;
	}

	public String toString() {
		String toReturn = "";
		if (isEmpty()) {
			return "Empty!" + "\n" + ".................................................";
		}
		Node current = front;
		while (current != last.next) {
			toReturn = toReturn + current + " | ";
			current = current.next;
		}
		return toReturn + "\n" + "......................................................................";
	}
}

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	public String toString() {
		return "" + data; 
	}
}
