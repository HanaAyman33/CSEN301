package Assignment5;
public class ShiftTheZeros {
	public static void main(String[] args) {
		QueueObj q = new QueueObj(11);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(0);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(0);
		q.enqueue(5);
		q.enqueue(0);
		q.enqueue(6);
		q.enqueue(0);
		q.enqueue(7);
		//q.printQueue();
		shift(q).printQueue();
	}
	public static QueueObj shift(QueueObj q) {
		QueueObj x = new QueueObj(q.size());
		int size = q.size();
		for(int i = 0;i<size;i++) {
			if((Integer)q.peek()==0)
				q.enqueue(q.dequeue());
			else
				x.enqueue(q.dequeue());
		}
		while(!q.isEmpty())
			x.enqueue(q.dequeue());
		return x;
	}
}
