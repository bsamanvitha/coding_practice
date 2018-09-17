
public class LinkedListQueue {
	public Node front;
	public Node last;
	public int size;
	public LinkedListQueue() {
		front = null;
		last = null;
		size = 0;
	}
	public boolean isEmpty() {
		return front == null;
	}
	public void removeAll() {
		front = null;
		size = 0;
	}
	public boolean enqueue(Node d) {
		if (front == null) {
			front = last = d;
		}
		else {
			last.next = d;
			last = d;
		}
		size += 1;
		return true;
	}
	
	public int size() {
		return size;
	}
	public Node dequeue() {
		if (isEmpty()) {
			return null;
		}
		Node d = front;
		front = front.next;
		size -= 1;
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
