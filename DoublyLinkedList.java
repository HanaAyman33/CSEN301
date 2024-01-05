package Assignment8;
class Link
{
	public Object data;
	public Link next;
	public Link previous;
	
	public Link(Object o)   
    {
    	data = o;
    } 
	
	public String toString() {
		return data.toString();
	}
}

class DoublyLinkedList
{
	private Link first; // reference to first link on list
	private Link last; // reference to first link on list
	
	public DoublyLinkedList()
	{
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	public void insertFirst(Object d)
	{
		Link newLink = new Link(d);
		if( isEmpty() ) { 
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink; 
	}
	
	public void insertLast(Object d)
	{
		Link newLink = new Link(d);
		if( isEmpty() ) 
			first = newLink; 
		else
		{
			last.next = newLink;
			newLink.previous = last; 
		}
		last = newLink;
	}
	
	public Object removeFirst() 
	{ 
		Object temp = first.data;
		if(first.next == null)
			last = null; 
		else
			first.next.previous = null; 
		first = first.next;
		return temp;
	}
	
	public Object removeLast()
	{ 
		Object temp = last.data;
		if(first.next == null)
			first = null;
		else
			last.previous.next = null; 
		last = last.previous; 
		return temp;
	}
	
	public Object getFirst()
	{
		return first.data;
	}
	
	public Object getLast()
	{
		return last.data;
	}
	
	public void displayForward()
	{
		System.out.print("[ ");
		Link current = first; 
		while(current != null) 
		{
		System.out.print(current + " ");
		current = current.next; 
		}
		System.out.println("]");
	}	
	
	public void displayBackward()
	{
		System.out.print("[ ");
		Link current = last; 
		while(current != null)
		{
			System.out.print(current + " "); 
			current = current.previous; 
		}
		System.out.println("]");
	}
	
	public int count() {//Problem1
		int cnt =0;
		for(Link curr = first;curr!=null;curr = curr.next)
			cnt++;
		return cnt;
		/*int cnt = 0
		 * Link curr = first;
		 * while(curr!=null){
		 * curr = curr.next;
		 * cnt++;
		 * }
		 * return cnt;
		 */
		
	}
	
	public int countRec() {//Problem1 recurvise method
		return helper(first);
	}
	public int helper(Link curr) {
		if(curr==null)
			return 0;
		return 1+ helper(curr.next);
	}
	
	public Object max() {//Problem2;
		if(first==last && last==null)
			return null;
		if(first==last)
			return first.data;
		Link curr = first;
		Comparable max = (Comparable) first.data;
		while(curr!=null) {
			if(max.compareTo(curr.data)<0)
				max = (Comparable) curr.data;
			curr = curr.next;
		}
		return max;
	}
	
	public Object maxRec() {//Problem2 recursively
		if(first==null)
			return null;
		return helper(first);
	}
	public Object helper2(Link curr) {
		if(curr.next==null)
			return curr.data;
		Comparable max = (Comparable) helper2(curr.next);
		if(max.compareTo(curr.data)<0)
			return max;
		return curr.data;
	}

	public boolean contains(Object o) {//Problem3
		Link curr = first;
		while(curr!=null) {
			if(curr.data.equals(o))
				return true;
			curr = curr.next;
		}
		return false;
	}
	
	public boolean containsRec(Object o) {//Problem3 recursively
		return helper3(first,o);
	}
	public boolean helper3(Link curr,Object o) {
		if(curr==null)
			return false;
		if(curr.data.equals(o))
			return true;
		return helper3(curr.next,o);
	}
	
	public void findPairs(int sum) {//Problem5
		Link curr1 = first;
		Link curr2 = last;
		boolean found = false;
		while(curr1!=curr2 && curr2.next!=curr1) {
			if(((int)(curr1.data)+(int)curr2.data)==sum) {
				found = true;
				System.out.println(((int)curr2.data+" "+(int)curr1.data));
				curr1 = curr1.next;
				curr2 = curr2.previous;
			}
			else {
				if(((int)(curr1.data)+(int)curr2.data)<sum)
					curr1 = curr1.next;
				else
					curr2 = curr2.previous;
			}
		}
		if(!found)
			System.out.println("No pair found");
	}
	
	public boolean insertAfter(Object key, Object dd) {//Problem7 a
		Link curr = first;
		while(!curr.data.equals(key)) {
			curr = curr.next;
			if(curr==null)
				return false;
		}
		Link newL = new Link(dd);
		if(curr==last) {
			newL.next = null;
			last = newL;
		}
		else {
			newL.next = curr.next;
			curr.next.previous = newL;
		}
		newL.previous = curr;
		curr.next = newL;
		return true;
	}
	
	public boolean insertBefore(Object key, Object dd) {//Problem7 b
		Link curr = first;
		while(!curr.data.equals(key)) {
			curr = curr.next;
			if(curr==null)
				return false;
		}
		Link newL = new Link(dd);
		if(curr==first) {
			newL.next = first;
			first = newL;
		}
		else {
			newL.next = curr;
			curr.previous.next = newL;
		}
		newL.previous = curr.previous;
		curr.previous = newL;
		return true;
	}
	
	public Object delete(Object key) {//Problem7 c
		Object res = null;
		if(first.data.equals(key)) {
			res = first.data;
			first = first.next;
		}
		else if(last.data.equals(key)) {
			res = last.data;
			last = last.previous;
		}
		else {
			Link curr = first;
			while(curr!=null) {
				if(curr.data.equals(key)) {
					res = key;
					curr.previous.next = curr.next;
					curr.next.previous = curr.previous;
					curr.next = null;
					curr.previous = null;
					break;
				}
				curr = curr.next;
				if(curr==null)
					return null;
			}
		}
		return key;
	}
	
	public void insertToSorted(Comparable x) {//Problem7 d
		if(first==null)
			first.data = x;
		else {
			Link curr = first;
			Link tmp = new Link(x);
			while(curr!=null) {
				if(x.compareTo(curr.data)<0) {
					tmp.next = curr;
					tmp.previous = curr.previous;
					if(curr.previous==null)
						curr.previous.next = tmp;
					else
						first = tmp;
					curr.previous = tmp;
					break;
				}
				if(curr.next==null) {
					curr.next = tmp;
					tmp.previous = curr;
					last = tmp;
					break;
				}
			}
		}
	}
	
	public void insertionSort() {//Problem7 e
		DoublyLinkedList tmp = new DoublyLinkedList();
		Link curr = first;
		while(curr!=null) {
			tmp.insertToSorted((Comparable) curr.data);
			curr = curr.next;
		}
		first = tmp.first;
		last = tmp.last;
	}
	
	public void reverse() {//Problem7 g
		Link curr = first;
		while(curr!=null) {
			if(curr.previous==null)
				last = curr;
			if(curr.next==null)
				first = curr;
			Link tmp = curr.previous;
			curr.previous = curr.next;
			curr.next = tmp;
			curr = curr.previous;
		}
	}
	
	public void reverse2() {//Problem7 h
		helper4(first);
	}
	public void helper4(Link curr) {
		if(curr!=null) {
			if(curr.previous==null)
				last = curr;
			if(curr.next==null)
				first = curr;
			Link tmp = curr.previous;
			curr.previous = curr.next;
			curr.next = tmp;
			helper4(curr.previous);
		}
	}
	
	public int countIter() {//Problem7 i
			int cnt = 0;
			for(Link curr = first;curr!=null;curr = curr.next)
				cnt++;
			return cnt;
	}
	
	public int countRecc() {//Problem7 j
		return helper5(first);
	}
	public int helper5(Link curr) {
		if(curr==null)
			return 0;
		return 1+ helper5(curr.next);
	}
	
	public void compressNEveryM(int n,int m) {
		Link curr1 = first;
		Link curr2 = first;
		while(curr1!=null) {
			for(int i = 0;i<m && curr1!=null && curr2!=null;i++) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			String tmp  = "";
			for(int i = 0;i<n && curr2!=null && curr1!=null;i++){
				if(i==n-1)
					tmp+=curr2.data+"";
				else
					tmp+=curr2.data+"~";
				curr2 = curr2.next;
			}
			Link nn = new Link(tmp);
			if(curr1!=null) {
				curr1.previous.next = nn;
				nn.previous = curr1.previous.next;
			}
			if(curr2!=null) {
				nn.next = curr2;
				curr2.previous = nn;
			}
			curr1 = curr2;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		a.insertLast("Ahmed");
		a.insertLast("Mona");
		a.insertLast("Khalid");
		a.insertLast("Mickey");
		a.insertLast("Mimi");
		a.insertLast("Toto");
		a.insertLast("Lolo");
		a.insertLast("Nona");
		a.insertLast("John");
		a.insertLast("Koko");
		a.insertLast("Fifi");
		a.displayForward();
		a.compressNEveryM(2, 3);
		a.displayForward();
		//a.displayBackward();
		//a.displayForward();
		//a.findPairs(7);
	}
}