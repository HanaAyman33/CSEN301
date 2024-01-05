package Assignment11;

import java.util.Arrays;

public class MyHashTable {
	private static int N = 11;
	private int[] table = new int[N];
	
	public int h(int key) {
		return (3 * key + 17)%N;
	}
	public MyHashTable() {
		Arrays.fill(table, -1);
	}
	
	public void insert(int key) {
		int index = key%10;//h(key)
		if(table[index]==-1)
			table[index] = key;
		else {
			if(index==9)
				index = 0;
			for(int i = index;i<N;i++) {
				if(table[i]==-1)
					table[i] = key;
			}
		}
	}
	
	public boolean find(int key) {
		int index = key%10;//h(key)
		if(table[index]==key)
			return true;
		else {
			if(index==9)
				index = 0;
			for(int i = index;i<N;i++) {
				if(table[i]==key)
					return true;
			}
			return false;
		}
	}
	
	public void display() {
		for(int i = 0;i<N;i++) {
			if(table[i]==-1)
				System.out.println(i+" -> ");
			else
				System.out.println(i+" -> "+table[i]);
		}
	}
	
	public static void main(String[] args) {
		MyHashTable ht = new MyHashTable();
		ht.insert(22);
		ht.insert(39);
		ht.insert(46);
		ht.insert(87);
		ht.insert(50);
		ht.insert(98);
		ht.display();
		System.out.println(ht.find(39));
		System.out.println(ht.find(46));
		System.out.println(ht.find(0));
		
	}
}
