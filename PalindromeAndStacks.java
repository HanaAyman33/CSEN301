package Assignment4;
public class PalindromeAndStacks {
	public static void main(String[] args) {
		String s = "Murder for a jar of red rum";
		System.out.println(palindrome(s.toLowerCase()));
	}
	public static boolean palindrome(String s) {
		StackObj st = new StackObj(s.length()/2);
		for(int i = 0;i<s.length()/2;i++) {
			if(s.charAt(i)!=' ')
				st.push(s.charAt(i));
		}
		int i;
		if(s.length()%2==0)
			i = s.length();
		else
			i = (s.length()/2) +1;
		while(i<s.length()) {
			if(s.charAt(i)==' ')
				i++;
			else if(s.charAt(i)!=(char)st.top())
				return false;
			else {
				i++;
				st.pop();
			}
		}
		return true;
	}
}
