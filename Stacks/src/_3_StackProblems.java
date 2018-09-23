import java.util.Stack;

public class _3_StackProblems {
	public static void main(String[] args) throws Exception {
		Stack2 stack = new Stack2();
		stack.push(new Node(3));
		stack.push(new Node(6));
		stack.push(new Node(9));
		stack.push(new Node(12));
		stack.push(new Node(15));
		System.out.println("After pushing 3, 6, 9, 12, 15");
		System.out.println(stack.toString());
		System.out.println("After popping last 2 elements: " + stack.pop() + ", " + stack.pop());
		System.out.println(stack.toString());
		Stack2 s = new Stack2();
		//System.out.println(s.infixToPostfix("a+b*c+d"));
		System.out.println(s.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
		int[] stocks = new int[]{100, 80, 60, 70, 60, 75, 85}; 
		int[] span = new int[stocks.length];
		stack.stockSpan(stocks, span); 
		System.out.println();
		stack.stockSpan2(stocks, span);
	}
	
}
class Stack2 extends _2_LinkedListStack {
	
	public Stack2() {
		super();
	}
	
	public String infixToPostfix(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i+1).equals("(")) {
				
				push(new Node(s.substring(i, i+1)));
			}
			else if (s.substring(i, i+1).equals(")")) {
				while (!peek().data.equals("(")) {
					result += pop().data;
				}
				pop();
			}
			else if (!ifOperation(s.substring(i, i+1))) {
				result += s.substring(i, i+1);
			}
			else {
				String fromStack = null;
				if (!isEmpty()) {
					fromStack = (String) peek().data;
				}
				if (isEmpty() || precendence(s.substring(i, i+1)) > precendence(fromStack)) {
					push(new Node(s.substring(i, i+1)));
				}
				else {
					fromStack = (String) peek().data;
					while (!isEmpty() && precendence(s.substring(i, i+1)) <= precendence(fromStack)) {
						result += pop();
						if (!isEmpty()) {
							fromStack = (String) peek().data;
						}
					}
					push(new Node(s.substring(i, i+1)));
				}
			}
		}
		while (!isEmpty()) {
			result += pop().data;
		}
		return result;
	}

	public boolean ifOperation(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")) {
			return true;
		}
		return false;
	}
	public int precendence(String s) {
		switch(s) { 
            case "+": 
            case "-":
                return 1; 
            case "*":
            case "/":
                return 2; 
            case "^": 
                return 3;  
        }
		return 0; 
	}
	
	// naive approach - O(n^2) due to 2 loops
	public void stockSpan(int[] stocks, int[] span) {
		span[0] = 1;
		for (int i = 1; i < stocks.length; i++) {
			span[i] = 1;
			int j = i - 1;
			while (j != 0 && stocks[j] < stocks[i]) {
				span[i]++;
				j--;
			}
		}
		printArray(span);
	}
	
	public void stockSpan2(int[] stocks, int[] span) {
		Stack<Integer> stack = new Stack<>();
		span[0] = 1;
		stack.push(0);
		for (int i = 1; i < stocks.length; i++) {
			while (!stack.isEmpty() && stocks[i] > stocks[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				span[i] = i+1;
			}
			else {
				span[i] = i-stack.peek();
			}
			stack.push(i);
		}
		printArray(span);
	}
	
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public boolean balancedParen(String s) {
		if (s.equals("")) {
			return false;
		}
		String[] braces = {"[", "{", "(", "]", "}", ")"};
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i+1).equals(braces[0]) || s.substring(i, i+1).equals(braces[1]) || s.substring(i, i+1).equals(braces[2])) {	//opening
				stack.push(s.substring(i, i+1));
			}
			else if (s.substring(i, i+1).equals("}") || s.substring(i, i+1).equals("]") || s.substring(i, i+1).equals(")")) {
				if (stack.isEmpty()) {
					return false;
				}
				else if (s.substring(i, i+1).equals("}") && !stack.pop().equals("{")) {
					return false;
				}
				else if (s.substring(i, i+1).equals(")") && !stack.pop().equals("(")) {
					return false;
				}
				else if (s.substring(i, i+1).equals("]") && !stack.pop().equals("[")) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
