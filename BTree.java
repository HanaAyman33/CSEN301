package Assignment9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{

	public Comparable data;
	public Node left,right;

	public Node (Comparable data){
		this(data, null, null);
	}

	public Node(Comparable data, Node left, Node right){

		this.data = data;
		this.left = left;
		this.right = right;
	}		
}
public class BTree {
	private Node root;

	public BTree() {
		root = null;
	}


	public void add(Comparable key) {
		Node current = root, parent = null;
		while (current != null) {
			if (key.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}

			else{
				parent = current;
				current = current.right;
			}
		}

		if (parent == null)
			root = new Node(key);

		else {
			if (key.compareTo(parent.data) < 0)
				parent.left = new Node(key);

			else
				parent.right = new Node(key);
		}
	}

	public boolean delete(Comparable key) {
        if (root == null)
               return false;
        Node current = root;
        Node parent = root;
        boolean right = true;
        // searching for the node to be deleted
        while (key.compareTo(current.data) != 0) {  
               if (key.compareTo(current.data) < 0) {       
            	   	 right = false;
                     parent = current;
                     current = current.left;
               } else {
                     right = true;
                     parent = current;
                     current = current.right;
               }
               if (current == null)
                     return false;
        }

        Node substitute = null;
        //  case 1: Node to be deleted has no children
        if (current.left == null && current.right == null)
               substitute = null;

        //  case 2: Node to be deleted has one child
        else if (current.left == null)
               substitute = current.right;
        else if (current.right == null)
               substitute = current.left;
        else // case 3: Node to be deleted has two children
        {
               Node successor = current.right;
               Node successorParent = current;
               //  searching for the inorder successor of the node to be deleted
               while (successor.left != null) {
                     successorParent = successor;
                     successor = successor.left;
               }
               substitute = successor;
               if (successorParent == current) {
                     if (successor.right == null)
                            successorParent.right = null;
                     else
                            successorParent.right = successor.right;
               } else {
                     if (successor.right == null)
                            successorParent.left = null;
                     else
                            successorParent.left = successor.right;
               }
               successor.right = current.right;
               successor.left = current.left;
               substitute = successor;
        } // case 3 done
        if (current == root) // Replacing the deleted node
               root = substitute;
        else if (right)
               parent.right = substitute;
        else
               parent.left = substitute;
        return true;

 }

	public void displayTree(){
		java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			java.util.Stack<Node> localStack = new java.util.Stack<Node>();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			}  // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
	}

	
	public static BTree idealBST(int[] a) {//Problem2
		BTree bt = new BTree();
		bt.root = helper(a,0,a.length-1);
		return bt;
	}
	public static Node helper(int[] a,int low, int high) {
		if(low>high)
			return null;
		int mid = (low+high)/2;
		Node n = new Node(a[mid]);
		n.left = helper(a,low,mid-1);
		n.right = helper(a,mid+1,high);
		return n;
	}
	
	public Comparable maxInBST() {//Problem3 max
		Node curr = root;
		while(curr.right!=null)
			curr = curr.right;
		return curr.data;
	}
	
	public Comparable minInBST() {//Problem3 min
		Node curr = root;
		while(curr.left!=null)
			curr = curr.left;
		return curr.data;
	}
	
	public int maxInBT() {//Problem4
		return helper2(root,1);
	}
	public int helper2(Node curr,int maxSoFar) {
		if(curr==null)
			return maxSoFar;
		if((int)curr.data>maxSoFar)
			maxSoFar = (int)curr.data;
		int maxL = helper2(curr.left,maxSoFar);
		int maxR = helper2(curr.right,maxSoFar);
		return Math.max(maxL, maxR);
	}
	
	public int size() {//Problem5 a
		return helper3(root);
	}
	public int helper3(Node curr) {
		if(curr==null)
			return 0;
		return 1 + helper3(curr.left) + helper3(curr.right);
	}
	
	public int numOfLeaves() {//Problem5 b
		return helper4(root);
	}
	public int helper4(Node curr) {
		if(curr==null)
			return 0;
		if(curr.left==null && curr.right==null)
			return 1;
		return helper4(curr.right) + helper4(curr.left);
	}
	
	public int sum() {//Problem5 c
		return helper5(root);
	}
	public int helper5(Node curr) {
		if(curr==null)
			return 0;
		return (int)curr.data + helper5(curr.left) + helper5(curr.right);
	}
	
	public boolean isBST() {//Problem5 d
		return helper6(root);
	}
	public boolean helper6(Node curr) {
		if(curr==null)
			return true;
		if(curr.left!=null && maxVal(curr.left).compareTo(curr.data)>0)
			return false;
		if(curr.right!=null && minVal(curr.right).compareTo(curr.data)<=0)
			return false;
		return helper6(curr.right) && helper6(curr.left);
	}
	public Comparable maxVal(Node node) {
		Node curr = node;
		while(curr.right!=null)
			curr = curr.right;
		return curr.data;
	}
	public Comparable minVal(Node node) {
		Node curr = node;
		while(curr.left!=null)
			curr = curr.left;
		return curr.data;
	}
	
	public int numLeftChildNodes() {//Problem5 e
		return helper7(root);
	}
	public int helper7(Node curr) {
		if(curr==null)
			return 0;
		if(curr.left!=null && curr.right==null)
			return 1 + helper7(curr.left);
		return helper7(curr.left) + helper7(curr.right);
	}
	
	public int countOccur(Comparable key) {//Problem5 f
		return helper8(root,key);
	}
	public int helper8(Node curr,Comparable key) {
		if(curr==null)
			return 0;
		if(curr.data.compareTo(key)==0)
			return 1 + helper8(curr.right,key) + helper8(curr.left,key);
		return helper8(curr.right,key) + helper8(curr.left,key);
	}
	
	public boolean hasDups(Comparable key) {//Problem5 g
		return countOccur(key)<2;
	}
	
	public void mirror() {//Problem5 h
		helper9(root);
	}
	public void helper9(Node curr) {
		if(curr!=null) {
			helper9(curr.left);
			helper9(curr.right);
			Node tmp = curr.left;
			curr.left = curr.right;
			curr.right = tmp;
		}
	}
	
	public String oddNodes() {//Problem5 i
		return helper10(root);
	}
	public String helper10(Node curr) {
		if(curr==null || (int)curr.data%2==0)
			return "";
		return curr.data + " " + helper10(curr.right) + helper10(curr.left);
	}
	
	public int levelIter(Comparable key) {//Problem6 iteratively
		Node curr = root;
		int i = 0;
		while(curr!=null) {
			if(curr.data.compareTo(key)==0)
				return i;
			if(curr.data.compareTo(key)<0)
				curr = curr.right;
			else
				curr = curr.left;
			i++;
		}
		return -1;
	}
	
	public int levelRec(Comparable key) {//Problem6 recursively
		return help(root,key);
	}
	public int help(Node curr,Comparable key) {
		if(curr==null || curr.data.compareTo(key)==0)
			return 0;
		if(curr.data.compareTo(key)<0)
			return 1 + help(curr.right,key);
		return 1 + help(curr.left,key);
	}
	
	public BTree doubleValues() {//Problem7
		BTree out = new BTree();
		doubleVal(root,out);
		return out;
	}
	public static void doubleVal(Node curr,BTree res) {
		if(curr==null)
			return;
		else {
			res.add((int)(curr.data)*2);
			doubleVal(curr.right,res);
			doubleVal(curr.left,res);
		}
	}
	
	public boolean equal(BTree t2) {//Problem8
		return eq(root,t2.root);
	}
	public boolean eq(Node curr1,Node curr2) {
		if(curr1==null && curr2==null)
			return true;
		if(curr1==null || curr2==null)
			return false;
		return  curr1.data.compareTo(curr2.data)==0
		&& eq(curr1.left,curr2.left) && eq(curr1.right,curr2.right);
	}
	
	public void printArm(int n) {//POP
		printArm(root,n);
	}
	public void printArm(Node curr,int n) {
		if(curr==null)
			return ;
		System.out.println(curr.data + "");
		if(n==0)
			printArm(curr.left,n);
		else printArm(curr.right,n);
	}
	
	public boolean DivBy(int n) {//POP
		return DivBy(root,n);
	}
	public boolean DivBy(Node curr,int n) {
		if(curr==null)
			return true;
		if((int)(curr.data)%2==1)
			return false;
		return true && DivBy(curr.right,n) && DivBy(curr.left,n);
	}
	
	public void printLevel(int lev) {//Problem4
		printLevel(root,lev,0);
	}
	public void printLevel(Node curr,int lev,int cnt) {
		if(curr==null)
			return;
		if(cnt==lev)
			System.out.println(curr.data + " ");
		cnt++;
		 printLevel(curr.left,lev,cnt);
		 printLevel(curr.right,lev,cnt);
	}

	public void breadthTraversal() {//Problem5
		if(root==null)
			return;
		LinkList q = new LinkList();
		q.insertLast(root);
		while(!q.isEmpty()) {
			Node n = (Node)q.removeFirst();
			System.out.println(n.data+" ");
			if(n.left!=null)
				q.insertLast(n.left);
			if(n.right!=null)
				q.insertLast(n.right);
		}
	}
	
	public void descendingOrder() {//Problem6
		descendingOrder(root);
	}
	public void descendingOrder(Node curr) {
		if(curr==null)
			return;
		descendingOrder(curr.right);
		System.out.println(curr.data+" ");
		descendingOrder(curr.left);
	}
	
	public void printRange(int low,int high) {//Problem7
		printRange(root,low,high);
	}
	public void printRange(Node curr,int low,int high) {
		if(curr==null)
			return;
		if((int)curr.data>=low && (int)curr.data<=high)
			System.out.println(curr.data+" ");
		printRange(curr.left,low,high);
		printRange(curr.right,low,high);
	}
	
	public void preorderIter() {//Problem8
		Node curr = root;
		if(curr==null)
			return;
		Stack<Node> st = new Stack<Node>();
		st.add(curr);
		while(!st.isEmpty()) {
			Node n = (Node)st.pop();
			System.out.println(n.data+" ");
			if(n.right!=null)
				st.push(n.right);
			if(n.left!=null)
				st.push(n.left);
		}
	}
	
	public LinkList path(Comparable key) {//Problem9
		LinkList res = new LinkList();
		Node curr = root;
		while(curr!=null) {
			res.insertLast(curr.data);
			if(curr.data.compareTo(key)==0)
				return res;
			if(curr.data.compareTo(key)<0)
				curr = curr.right;
			else
				curr = curr.left;
		}
		return res;
	}
	
	public int heightRec() {//Problem10 a
		return heightRec(root);
	}
	public int heightRec(Node curr) {
		if(curr==null)
			return -1;
		int maxL = heightRec(curr.left);
		int maxR = heightRec(curr.right);
		return 1 + Math.max(maxL, maxR);
	}
	
	public int heightIter() {//Problem10 b
		//Using 2 queues,or LinkedLists can be used
		Node curr = root;
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		int level = 0;
		q1.offer(curr);
		while(!q1.isEmpty()) {
			Node n = (Node)q1.poll();
			if(n.left!=null) {
				q2.offer(n.left);
			}
			if(n.right!=null) {
				q2.offer(n.right);
			}
			if(q1.isEmpty())
				level++;
			while(!q2.isEmpty())
				q1.offer(q2.poll());
		}
		return level;
	}
	
	public boolean checkSum() {//Quiz BI
		if(root==null)
			return false;
		int lsum = sumLeaves(root.left);
		int rsum = sumLeaves(root.right);
		return lsum==rsum;
	}
	public int sumLeaves(Node curr) {
		if(curr==null)
			return 0;
		if(curr.left==null && curr.right==null)
			return (int)curr.data;
		return sumLeaves(curr.left) + sumLeaves(curr.right);
	}
	
	public BTree InOrder() {
		BTree bt = new BTree();
 		InOrder(root,bt);
 		return bt;
	}
	public void InOrder(Node curr,BTree bt) {
		if(curr==null)
			return;
		InOrder(curr.left,bt);
		bt.add(curr.data);
		InOrder(curr.right,bt);
		/*PostOrder traversal:-
		 * InOrder(curr.left);
		 * InOrder(curr.right);
		 * System.out.print(curr.data+" ");
		 */
	}
	public boolean isUnival() {//checks if a BT is univalued
		if(root==null)
			return true;
		return isUnival(root);
	}
	public boolean isUnival(Node curr) {
		if(curr==null)
			return true;
		if(!curr.data.equals(root.data))
			return false;
		return isUnival(curr.left) && isUnival(curr.right);
	}
	
	public static void main(String[] args) {
		BTree bt = new BTree();
		bt.add(5);
		bt.add(3);
		bt.add(6);
		bt.add(2);
		bt.add(4);
		bt.add(1);
		bt.add(8);
		bt.add(7);
		bt.add(9);
		bt.displayTree();
		//int[] a = {1,2,3,4,5,6};
		//bt.idealBST(a).displayTree();
		//System.out.println(bt.maxInBST());
		//System.out.println(bt.maxInBT());
		//System.out.println(bt.maxInBST());
		//System.out.println(bt.size());
		//System.out.println(bt.numOfLeaves());
		//System.out.println(bt.sum());
		//System.out.println(bt.isBST());
		//System.out.println(bt.numLeftChildNodes());
		//System.out.println(bt.countOccur(40));
		//System.out.println(bt.hasDups(40));
		//bt.mirror();
		//bt.displayTree();
		//System.out.println(bt.levelRec(40));
		//bt.doubleValues().displayTree();
		//System.out.println(bt.equal(bt2));
		//bt.printArm(1);
		//System.out.println(bt.DivBy(2));
		//bt.printLevel(2);
		//bt.printTraversal();
		//bt.descendingOrder();
		//bt.printRange(20, 90);
		//bt.preorderIter();
		//System.out.println(bt.path(5).toString());
		//System.out.println(bt.heightRec());
		//System.out.println(bt.heightIter());
		//System.out.println(bt.check());
		//System.out.println(bt.checkSum());
		//bt.InOrder().displayTree();;
	}
}
	
