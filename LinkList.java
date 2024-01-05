package Assignment7;
class Link {
	public Object data;
	public Link next;

	public Link(Object o) {
		this.data = o;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}
}
public class LinkList {
	private Link head;

	public LinkList() {
		head = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		newLink.next = head;
		head = newLink;
	}

	public Object removeFirst() {
		Object res = head.data;
		head = head.next;
		return res;
	}

	public Object getFirst() {
		return head.data;
	}

	public void insertLast(Object o) {
		Link newLink = new Link(o);
		if (head == null) {
			head = newLink;
			return;
		}
		Link current = head;
		while (current.next != null)
			current = current.next;
		current.next = newLink;
	}
	
	public Object removeLast() {
		if (head.next == null) {
			Object res = head.data;
			head = null;
			return res;
		}
		Link current = head;
		while (current.next.next != null)
			current = current.next;
		Object res = current.next.data;
		current.next = null;
		return res;
	}

	public Object getLast() {
		Link current = head;
		while (current.next != null)
			current = current.next;
		return current.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {

		if (head == null)
			return "[ ]";
		String res = "[ " + head.data;
		Link current = head.next;
		while (current != null) {
			res += ", " + current.data;
			current = current.next;
		}
		res += " ]";
		return res;
	}
	public void insertLastRec(Object o){//Problem 1
		helper(o,head);
	}
	public void helper(Object o,Link curr) {
		Link l = new Link(o);
		if(head==null)
			head = l;
		else if(curr.next==null)
			curr.next = l;
		else
			helper(o,curr.next);
		
	}
	
	public LinkList reverse() {//Problem2
		LinkList rev = new LinkList();
		Link curr = head;
		while(curr!=null) {
			Link tmp = new Link(curr.data);
			tmp.next = rev.head;
			rev.head = tmp;
			curr = curr.next;
		}
		return rev;
	}
	
	public void reverse2() {//Problem3
		Link curr1 = head;
		Link curr2 = null;
		while(curr1.next!=null){
			head = curr1;
			head.next = curr2;
			curr2 = curr1;
			curr1 = curr1.next;
		}
		head = curr1;
	}
	
	public void mix() {//Problem5
		// set initial variables
		LinkList res = new LinkList();
		Link curr = head;
		Link curr1 = head;
		Link curr2 = head;
		// get count of elements
		int cnt2 = 0;
		int cnt1 = 1;
		while(curr.next!=null) {
			curr = curr.next;
			cnt2++;
		}
		res.head = curr;
		while(cnt1!=cnt2) {
			int tmp1 = cnt1,tmp2 = cnt2;
			while(tmp1>0) {
				curr1 = curr1.next;
				tmp1--;
			}
			while(tmp1>=0) {
				curr = curr.next;
			}
			curr = curr1;
			while(tmp2-->=0) {
				curr2 = curr2.next;
			}
			while(tmp2-->=0) {
				curr = curr.next;
			}
			curr = curr2;
			cnt1++;
			cnt2--;
		}
		head = res.head;
	}

	public void delete(int m,int n) {//Problem 6
		Link curr1 = head;
		Link curr2 = head;
		while(curr1.next!=null) {
			for(int i = 1;i<m;i++) {
				curr1 = curr1.next;
				curr2 = curr2.next;
				if(curr1==null)
					return;
			}
			for(int i = 0;i<n+1 && curr2!=null;i++)
				curr2 = curr2.next;
			curr1.next = curr2;
			if(curr2!=null)
				curr1 = curr2;
		}
	}
	
	public void addOne() {//Problem7
		Link curr = head;
		while(curr!=null) {
			int num = (Integer)curr.data;
			curr.data = num+1;
			curr = curr.next;
		}
		
	}
	
	public void addOneRec() {//Problem7
		helper(head);
	}
	public void helper(Link curr) {
		if(curr!=null) {
			int num = (Integer)curr.data;
			curr.data = num+1;
			helper(curr.next);
		}
	}
	
	public void cut() {//Problem8
		Link curr1 = null;
		Link curr2 = head;
		int cnt = 0;
		while(curr2!=null) {
			curr2 = curr2.next;
			cnt++;
		}
		curr2 = head;
		for(int i = 1;i<(cnt/2)+(cnt%2);i++)
			curr2 = curr2.next;
		curr1 = curr2;
		while(curr2.next!=null)
			curr2 = curr2.next;
		curr2.next = head;
		head = curr1.next;
		curr1.next = null;
	}
	
	public void swap() {
		Link curr = head;
		Link curr2 = curr;
		LinkList res = new LinkList();
		res.head = curr2;
		while(curr.next.next!=null){
			
		}
	}
	
	public LinkList doubling() {//Returns the double of a given number
		LinkList res = new LinkList();
		Link curr = head;
		Link curr2 = new Link(curr.data);
		res.head = curr2;
		while(curr!=null){
			if(curr.equals(head) && (int)(curr.data)*2>9) {
				curr2.data = 1;
				curr2.next = new Link(null);
				curr2 = curr2.next;
			}
			if((int)(curr.data)*2>9 && curr.next==null)
				curr2.data = (((int)curr.data)*2)%10;
			else if((int)(curr.data)*2>9 && (int)(curr.next.data)*2>9)
				curr2.data = (((int)curr.data)*2)%10 + 1;
			else
				curr2.data = (((int)curr.data)*2) + 1;
			curr = curr.next;
			if(curr!=null)
				curr2.next = new Link(null);
			curr2 = curr2.next;
		}
		return res;
	}
	
	public void remove() {//removes duplicates from a list
		Link curr1 = head;
		Link curr2 = curr1.next;
		while(curr1!=null && curr2!=null) {//remove duplicates only
			while(curr2.next!=null && curr2.data.equals(curr2.next.data))
				curr2 = curr2.next;
			curr1.next = curr2;
			curr1 = curr2;
			curr2 = curr2.next;
		}
		/*while(curr1!=null && curr2!=null) {//remove all number duplicates 
			boolean flag = false;
			while(curr2.next!=null && curr2.data.equals(curr2.next.data)) {
				flag = true;
				curr2 = curr2.next.next;
			}
			if(!flag)
				curr1 = curr1.next;
			else
				curr1.next = curr2;
			curr2 = curr2.next;
		}*/
		
	}
	
	public void sumBetweenZeroes() {//Quiz2 solution
		Link curr1 = head;
		Link curr2 = head;
		while(curr1!=null && curr2!=null) {
			while((int)curr2.data==0 && curr2.next!=null)
				curr2 = curr2.next;
			int sum = 0;
			while((int)curr2.data!=0 && curr2.next!=null) {
				sum+=(int)curr2.data;
				curr2 = curr2.next;
			}
			curr1.data = sum;
			curr1 = curr1.next;
		}
		curr2 = head;
		while((int)curr2.next.data!=0)
			curr2 = curr2.next;
		curr2.next = null;
	}
	
	public static void main(String[] args) {
		LinkList a = new LinkList();
		a.insertFirst(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(4);
		a.insertLast(5);
		a.insertLast(6);
		a.insertLast(7);
		System.out.println(a.toString());
		//a.sumBetweenZeroes();
		//a.remove();
		//System.out.println(a.doubling().toString());
		//a.delete(2, 2);
		a.cut();
		//System.out.println(a.toString());
		//a.reverse2();
		//a.mix();
		//
		//a.addOne();
		//a.addOneRec();
		System.out.println(a.toString());
		//System.out.println(a.reverse().toString());
	}
}
