package Assignment4;

public class InfixToPostfix {
	public static void main(String[] args) {
		String infix = "1+2*3+4";
		System.out.println(postfix(infix));
	}
	public static int getPrior(char oper) {
		if(oper=='*')
			return 1;
		else if(oper=='+')
			return 2;
		else
			return 3;
	}
	public static String postfix(String infix) {
		StackObj s = new StackObj(infix.length());
		String result = "";
		for(int i = 0;i<infix.length();i++) {
			char c = infix.charAt(i);
			if(c>='0' && c<='9')
				result+=c+"";
			else {
				if(s.isEmpty())
					s.push(c);
				else {
					int currentP = getPrior(c);
					int stackP = getPrior((char) s.top());
					while(stackP>=currentP) {
						result+=(char)s.pop()+"";
						if(s.isEmpty())
							break;
						stackP = getPrior((char) s.top());
					}
					s.push(c);
				}
			}
		}
		while(!s.isEmpty())
			result+=(char)(s.pop())+"";
		return result;
	}
}
