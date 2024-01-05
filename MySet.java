package Assignment4;
public class MySet {
	int[] a;
	int size;
	int e;
	public MySet(int size,int e) {
		a = new int[size];
		this.e = e;
	}
	public int cardinality() {
		return e;
	}
	public void insert(int element) {
		if(e<size) {
			e++;
			a[e] = element;
		}
	}
	public void remove(int element) {
		for(int i = 0;i<e;i++) {
			if(a[i]==element) {
				for(int j = e;j>i;j--) {
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
				break;
			}
		}
		e--;
	}
	public boolean check(int element) {
		for(int i = 0;i<e;i++) {
			if(a[i]==element)
				return true;
		}
		return false;
	}
	public void replace(int x, int y) {
		boolean flag = false;
		int index = 0;
		for(int i = 0;i<e;i++) {
			if(a[i]==x) {
				index = i;
				flag = true;
				break;
			}
		}
		if(flag) 
			a[index] = y;
		else {
			if(e<size)
				e++;
				a[e] = y;
		}
	}
	public boolean isEmpty() {
		return e==0;
	}
}
