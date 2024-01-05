package Assignment1;
public class LinearSortedArray {
	int[] a;
	int size;
	int e;
	public LinearSortedArray(int size) {
		a = new int[size];
		e = 0;
	}
	public void orderedInsert(int x) {
		if(e<size) {
			int j = 0;
			for(int i = e;i>0 && a[i-1]>x;i--)
				a[i] = a[i-1];
			a[j] = x;
			/*int index = 0;
			for(int i = 0;i<e;i++) {
				if(a[i]>x) {
					index = i;
					break;
				}
			}
			for(int i = e;i>index;i--)
				a[i] = a[i-1];
			a[index] = x;*/
			e++;
		}
	}
	public int binarySearchRec(int x,int start,int end){
		int mid = (start+end)/2;
		if(a[mid]==x)
			return mid;
		else if(a[mid]>x)
				return binarySearchRec(x,start,mid-1);
		else if(a[mid]<x)
				return binarySearchRec(x,mid+1,end);
		else
			return -1;
		}
	public  boolean binarySearchIter(int n) {
		int start = 0;
		int end = size-1;
		int mid;
		while(start<=end){
			mid = (start+end)/2;
			if(a[mid]==n)
				return true;
			else {
				if(a[mid]<n)
					start = mid+1;
				else
					end = mid-1;
			}
		}
		return false;
	}
	public void delete(int x) {
		int index = 0;
		for(int i = 0;i<e;i++) {
			if(a[i]==x) {
				index = i;
				break;
			}
		}
		for(int i = index;i+1<e;i++) {
			a[i] = a[i+1];
		}
		e--;
	}
	public void display() {
		for(int i = 0;i<e;i++)
			System.out.print(a[i]+" ");
	}
	public static void  main(String[] args) {
		LinearSortedArray a = new LinearSortedArray(4);
		a.orderedInsert(78);
		a.orderedInsert(56);
		a.orderedInsert(34);
		a.orderedInsert(23);
		a.display();
		//System.out.println(a.binarySearchIter(34));
		//System.out.println(a.binarySearchRec(34, 0, a.e));
		//a.display();
		//a.delete(23);
		//System.out.println();
		
	}
}