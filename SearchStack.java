package Assignment3;
public class SearchStack {
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(4);
		s.push(9);
		s.push(34);
		s.push(99);
		s.push(56);
		System.out.println(search(s,0));
	}
	public static int search(ArrayStack s,int x) {
		ArrayStack tmp = new ArrayStack(s.size());
		int pos = 0;
		while(!s.isEmpty()) {
			if(s.top()==x)
				break;
			else {
				tmp.push(s.pop());
				pos++;
			}
		}
		if(s.size()==0 && pos!=s.size()-1)
			return -1;
		while(!tmp.isEmpty())
			s.push(tmp.pop());
		return pos;
	}
}
