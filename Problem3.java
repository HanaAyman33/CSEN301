package Assignment8;
public class Problem3 {
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		a.insertLast(1);
		a.insertLast(2);
		a.insertLast(134);
		a.insertLast(190);
		a.displayForward();
		System.out.println(contains(a,134));
	}
	public static boolean contains(DoublyLinkedList a,Object o) {
		DoublyLinkedList tmp = new DoublyLinkedList();
		boolean flag = false;
		while(!a.isEmpty()) {
			if(a.getFirst().equals(o))
				flag = true;
			tmp.insertLast(a.removeFirst());
		}
		while(!tmp.isEmpty())
			a.insertLast(tmp.removeFirst());
		return flag;
	}
}
