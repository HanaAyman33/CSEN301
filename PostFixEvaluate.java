package Assignment3;
public class PostFixEvaluate {
	public static void main(String[] args) {
		String s = "234+*";
		System.out.println(evaluate(s));
	}
	public static int evaluate(String s) {
		ArrayStack x = new ArrayStack(s.length());
		int num1 = 0,num2 = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i)>='0' && s.charAt(i)<='9')
				x.push(Integer.parseInt(s.charAt(i)+""));
			else {
				num1 = x.pop();
				num2 = x.pop();
				switch(s.charAt(i)) {
					case '+': x.push(num1+num2);break;
					case '-': x.push(num2-num1);break;
					case '/': x.push(num2/num1);break;
					case '*': x.push(num1*num2);break;
				}
			}
		}
		return x.pop();
	}
}
