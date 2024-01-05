package Assignment2;
public class RelativeSort {
	public static void sortRelative(int[] a1,int[] a2) {
		int tmp,k = 0;
		for(int i = 0;i<a2.length;i++) {
			for(int j = 0;j<a1.length;j++){
				if(a2[i]==a1[j]) {
					tmp = a1[k];
					a1[k]= a1[j];
					a1[j] = tmp;
					k++;
				}
			}
		}
		for(int i = k;i<a1.length-1;i++) {
			for(int j = k;j<a1.length-1;j++) {
				if(a1[j]>a1[j+1]) {
					tmp = a1[j];
					a1[j] = a1[j+1];
					a1[j+1] = tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] a1 = {2,1,2,5,7,1,9,3,6,8,8};
		int[] a2 = {2,1,8,3};
		sortRelative(a1,a2);	
		for(int i = 0;i<a1.length;i++)
			System.out.print(a1[i]+" ");
	}
}
