
public class _1_QueueProblems {
	public static void main(String[] args) throws Exception {
		LLQ queue = new LLQ();
		queue.enqueue(new Node(3));
		queue.enqueue(new Node(6));
		queue.enqueue(new Node(9));
		queue.enqueue(new Node(12));
		queue.enqueue(new Node(15));
		System.out.println("After adding: ");
		System.out.println(queue.toString());
		System.out.println("After removing 2 elements: ");
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.toString());
		
		LLQ var = new LLQ(); 
		
		var.enqueue(new Node(3));
		var.enqueue(new Node(6));
		var.enqueue(new Node(9));
		System.out.println(var.toString());
		System.out.println(var.toString());
	}
	
}
class LLQ extends LinkedListQueue {
	
	public LLQ() {
		super();
	}
	
}
