package Assignment8;
public class Problem2 {
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		a.insertLast(1);
		a.insertLast(2);
		a.insertLast(134);
		a.insertLast(190);
		a.displayForward();
		System.out.println(max(a).toString());
	}
	public static Object max(DoublyLinkedList a) {
		if(a.isEmpty())
			return null;
		Comparable max = (Comparable) a.removeFirst();
		while(!a.isEmpty()) {
			Object tmp = a.removeFirst();
			if(max.compareTo(tmp)<0)
				max = (Comparable) tmp;
		}
		return max;
	}
}
