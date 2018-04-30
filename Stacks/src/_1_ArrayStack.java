
public class _1_ArrayStack {
	private static final int totalSize = 15;
	private int top; //index of the top element
	private Node[] stack;
	
	public _1_ArrayStack() {
		this(totalSize);
	}
	public _1_ArrayStack(int initialSize) {
		if (initialSize <= 0) {
			stack = new Node[totalSize];
		}
		else {
			stack = new Node[initialSize];
		}
		top = -1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == stack.length-1;
	}
	public boolean push(Node d) throws Exception {
		if (!isFull()) {
			top++;
			stack[top] = d;
			return true; 
		}
		throw new Exception("Full!");
	}
	public Node peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty!");
		}
		return stack[top];
	}
	public Node pop() {
		if (!isEmpty()) {
			Node d = stack[top];
			stack[top] = null;
			top--;
			return d;
		}
		return null;
	}
	public boolean removeAll() {
		for (int i = 0; i <= top; i++) {
			stack[i] = null;
		}
		top = -1;
		return true;
	}
	public String toString() {
		String toReturn = "";
		if (isEmpty()) {
			return "Empty!" + "\n" + ".................................................";
		}
		for (int i = 0; i < top; i++) {
			toReturn = toReturn + stack[i] + " || ";
		}
		toReturn = toReturn + stack[top];
		return toReturn + "\n" + "......................................................................";
	}
	
	public static void main(String[] args) throws Exception {
		_1_ArrayStack stack = new _1_ArrayStack();
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

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	public String toString() {
		return "Node: " + data; 
	}
}