
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
	public Node pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty!");
		}
		Node d = top;
		top = top.next;
		return d;
	}
	public Node peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty!");
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
	public static void main(String[] args) throws Exception {
		_2_LinkedListStack stack = new _2_LinkedListStack();
		stack.push(new Node(3));
		stack.push(new Node(6));
		stack.push(new Node(9));
		stack.push(new Node(12));
		stack.push(new Node(15));
		System.out.println("After pushing 3, 6, 9, 12, 15");
		System.out.println(stack.toString());
		System.out.println("After popping last 2 elements: " + stack.pop() + ", " + stack.pop());
		System.out.println(stack.toString());
	}
}


