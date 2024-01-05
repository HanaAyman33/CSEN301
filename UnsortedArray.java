package Assignment1;
public class UnsortedArray {
	int[] a;
	int size;
	int elements;
	public UnsortedArray(int size) {
		a = new int[size];
		elements = 0;
	}
	public void insertLast(int x) {
			a[elements] = x;
			elements++;
	}
	public void insertFirst(int x) {
			for(int i = elements;i-1>=0;i--)
				a[i] = a[i-1];
			a[0] = x;
			elements++;
	}
	public int linearSearch(int x) {
		for(int i = 0;i<elements;i++) {
			if(a[i]==x) 
				return i;
		}
		return -1;
	}
	public void delete(int x) {
		int index = 0;
		for(int i = 0;i<elements;i++) {
			if(a[i]==x) {
				index = i;
				break;
			}
		}
		for(int i = index;i+1<elements;i++) {
			a[i] = a[i+1];
		}
		elements--;
	}
	public void display() {
		for(int i = 0;i<elements;i++)
			System.out.print(a[i]+" ");
	}
	public static void  main(String[] args) {
		UnsortedArray a = new UnsortedArray(4);
		a.insertFirst(21);
 		a.insertFirst(34);
 		a.insertFirst(90);
 		a.insertFirst(78);
 		//System.out.println(a.linearSearch(34));
 		//a.insertLast(45);
 		//a.delete(21);
 		a.display();
	}
	
}
