package Assignment7;
public class Problem10 {
	public static void alternate(LinkList a) {
		LinkList one = new LinkList();
		LinkList two = new LinkList();
		int cnt = count(a);
		int i = 0;
		while(i<cnt){
			one.insertLast(a.getFirst());
			a.insertLast(a.removeFirst());
			i++;
			if(i>=cnt)
				break;
			two.insertLast(a.getFirst());
			a.insertLast(a.removeFirst());
			i++;
		}
		System.out.println("First sublist: "+one.toString());
		System.out.print("Second sublist: "+two.toString());
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
		a.insertLast('a');
		a.insertLast('b');
		a.insertLast('c');
		a.insertLast('d');
		a.insertLast('e');
		System.out.println(a.toString());
		alternate(a);
		//System.out.println(a.toString());
	}
}
