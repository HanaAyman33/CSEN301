package Assignment1;
public class BinarySearch {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,533,2,42};
		//System.out.println(recursively(a,1,0,11));
		System.out.println(search(a,90));
	}
	public static int recursively(int[] a,int n,int start,int end) {
		int mid = (start+end)/2;
		if(start>end)
			return mid;
		else {
			if(a[mid]>n)
				return recursively(a,n,start,mid-1);
			else
				return recursively(a,n,mid+1,end);
		}
	}
	public static boolean search(int[] a,int n) {
		int start = 0;
		int end = a.length-1;
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
}
