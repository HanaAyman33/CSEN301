package Assignment8;

public class Problem6 {
	public static DoublyLinkedList nodeToList(Link n) {
		DoublyLinkedList a = new DoublyLinkedList();
		String s = n+"";
		for(int i = 0;i<s.length();i++) {
			a.insertLast(s.charAt(i));
		}
		return a;
	}
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		a.insertLast(1);
		a.insertLast(1);
		a.insertLast(1);
		a.insertLast(1);
		//a.displayForward();
		nodeToList(new Link(147)).displayForward();
	}
}
