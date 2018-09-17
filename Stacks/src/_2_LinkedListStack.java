
public class _2_LinkedListStack {
	private Node top;
	public _2_LinkedListStack() {
		top = null;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public void removeAll() {
		top = null;
	}
	public boolean push(Node d) {
		d.next = top;
		top = d;
		return true;
	}
	public Node pop() {
		if (isEmpty()) {
			return null;
		}
		Node d = top;
		top = top.next;
		return d;
	}
	public Node peek() {
		if (isEmpty()) {
			return null;
		}
		return top;
	}
	public String toString() {
		String toReturn = "";
		if (isEmpty()) {
			return "Empty!" + "\n" + ".................................................";
		}
		Node current = top;
		while (current != null) {
			toReturn = toReturn + current + " || ";
			current = current.next;
		}
		return toReturn + "\n" + "......................................................................";
	}
}


