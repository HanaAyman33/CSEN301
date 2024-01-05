package Assignment7;
import java.util.LinkedList;
public class Problem1 {
	public static void main(String[] args) {
		LinkList a = new LinkList();
		insertLast(a,1);
		insertLast(a,2);
		insertLast(a,3);
		insertLast(a,4);
		//a.removeLast();
		//insertLast(a,5);
		System.out.println(a.toString());
	}
	public static void insertLast(LinkList a,Object o) {
		Link l = new Link(o);
		if(a.isEmpty())
			a.insertFirst(l);
		else {
			a.insertLast(l);
		}
	}
	public Object removeLast() {
		return removeLast();
	}
}
