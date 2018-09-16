
public class _1_QueueProblems {
	public static void main(String[] args) throws Exception {
		LinkedListQueue queue = new LinkedListQueue();
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
	}
}
