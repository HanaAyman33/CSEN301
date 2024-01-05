package Assignment8;
//Problem4
public class CircularLinkedList {
	Link last;

	public CircularLinkedList() {
		last = null;
	}

	public void insertFirst(Object o) {
		Link newL = new Link(o);
		if(last==null)
			last = newL;
		else
			newL.next = last.next;
		last.next = newL.next;
	}
	public void insertLast(Object o) {
		Link newL = new Link(o);
		if(last==null) {
			last = newL;
			last.next = newL;
		}
		else {
			newL.next = last.next;
			last.next = newL;
			last = newL;
		}
	}
	public Object removeFirst() {
		Object tmp = null;
		if(last.next==last) {
			tmp = last.data;
			last = null;
		}
		else {
			tmp = last.next.data;
			last.next = last.next.next;
		}
		return tmp;
	}
	public Object removeLast() {
		Object tmp = null;
		if(last.next==last) {
			tmp = last.data;
			last = null;
		}
		else {
			Link curr = last;
			while(curr.next!=last)
				curr = curr.next;
			curr.next = curr.next.next;
			last = curr;
		}
		return tmp;
	}
	public boolean isEmpty() {
		return last==null;
	}
	public String toString() {
		String res = "[";
		if(!isEmpty()) {
			Link curr = last;
			while(curr.next!=null)
				res+=curr.data+" ";
				curr = curr.next;
		}
		res+="]";
		return res;
	}
	public void append(CircularLinkedList l2) {
		if(last==null)
			last = l2.last;
		else {
			Link first = last.next;
			last.next = l2.last.next;
			l2.last.next = first;
			last = l2.last;
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedList a = new CircularLinkedList();
		a.insertLast(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(0);
		System.out.println(a);
		
	}
}
