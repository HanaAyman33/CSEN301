package Assignment9;

public class Linkk {
	Linkk root;
	int leftval;
	int rightval;
	Linkk left;
	Linkk right;
	Linkk mid;
	public Linkk(int leftval,int rightval){
		this.leftval = leftval;
		this.rightval = rightval;
		left = null;
		right = null;
		mid = null;
	}
	public void insert(Object o) {
		Linkk l = (Linkk)o;
		Linkk curr = root;
		if(curr==null)
			root = new Linkk(l.leftval,l.rightval);
		else {
			while(curr!=null) {
				if(curr.leftval>l.leftval)
					curr = curr.left;
				if(curr.rightval<l.rightval)
					curr = curr.right;
				else
					curr = curr.mid;
			}
			curr = new Linkk(l.leftval,l.rightval);
		}
	}
	public Linkk search(int n) {
		return search(root,n);
	}
	public Linkk search(Linkk curr,int n) {
		if(curr==null)
			return null;
		if(curr.leftval==n || curr.rightval==n)
			return curr;
		if(curr.leftval>n)
			return search(curr.left,n);
		if(curr.rightval<n)
			return search(curr.right,n);
		return search(curr.mid,n);
	}
	
}
