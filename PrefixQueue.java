package Assignment5;
public class PrefixQueue {
	public static void main(String[] args) {
		System.out.println(evaluate("+10*23"));
	}
	public static int evaluate(String s) {
		QueueObj q = new QueueObj(s.length());
		for(int i = 0;i<s.length();i++)
			q.enqueue(s.charAt(i));
		int result = 0 ;
		while(!q.isEmpty()) {
			if((Integer)q.peek()>='0' && (Integer)q.peek()<='9')
				q.enqueue(q.dequeue());
			else {
				char oper = (Character)q.dequeue();
				int i1 = (Integer)q.dequeue();
				int i2 = (Integer)q.dequeue();
				if(i1>='0' && i1<='9' && i2>='0' && i2<='9') {
					switch(oper) {
					case '+': result = i1+i2;break;
					case '-': result = i2-i1;break;
					case '*': result = i1*i2;break;
					case '/': result = i2/i1;break;
					}
				}
				else
					q.enqueue(oper);
			}
		}
		return result;
	}
}
