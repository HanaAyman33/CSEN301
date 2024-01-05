package Assignment8;
public class QueueDDLL {
	DoublyLinkedList queue;
	public QueueDDLL() {
		queue = new DoublyLinkedList();
	}
	
	public void enqueue(Object o) {//O(1)
		queue.insertLast(o);
	}
	
	public Object dequeue() {//O(1)
		return queue.removeFirst();
	}
	
	public Object peek() {//O(1)
		return queue.getFirst();
	}
	
	public boolean isEmpty() {//O(1)
		return queue.isEmpty();
	}
	
	public int size() {//O(n)
		DoublyLinkedList tmp = new DoublyLinkedList();
		int cnt = 0;
		while(!queue.isEmpty()) {
			cnt++;
			tmp.insertLast(queue.removeFirst());
		}
		while(!tmp.isEmpty())
			queue.insertLast(tmp.removeFirst());
		return cnt;
	}
	
}
