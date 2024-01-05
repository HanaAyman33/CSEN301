package Assignment7;
public class Problem9 {
	public static void split(LinkList a) {//split the list into two lists
		LinkList first = new LinkList();
		LinkList second = new LinkList();
		int cnt = count(a);
		int index;
		if(cnt%2==0)
			index = cnt/2;
		else
			index = (cnt/2)+1;
		for(int i = 0;i<index;i++) {
			first.insertLast(a.getFirst());
			a.insertLast(a.removeFirst());
		}
		for(int i = index;i<cnt;i++) {
			second.insertLast(a.getFirst());
			a.insertLast(a.removeFirst());
		}
		System.out.println("first sublist: "+first.toString());
		System.out.print("second sublist: "+second.toString());
	}
	public static int count(LinkList a) {//get number of nodes
		LinkList tmp = new LinkList();
		int cnt = 0;
		while(!a.isEmpty()) {
			cnt++;
			tmp.insertLast(a.removeFirst());
		}
		while(!tmp.isEmpty())
			a.insertLast(tmp.removeFirst());
		return cnt;
	}
	public static void main(String[] args) {
		LinkList a = new LinkList();
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(5);
		a.insertLast(7);
		a.insertLast(11);
		System.out.println(a.toString());
		split(a);
		//System.out.println(a.toString());
	}
}
