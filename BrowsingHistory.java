package Assignment4;

public class BrowsingHistory {
	StackObj history;
	StackObj helper;
	public BrowsingHistory() {
		history = new StackObj(1000);
		helper = new StackObj(1000);
	}
	public BrowsingHistory(int maxSize) {
		history = new StackObj(maxSize);
		helper = new StackObj(maxSize);
	}
	public void add(String url) {
		int fr = 0;
		Link l = null;
		while(!history.isEmpty()) {
			l = (Link) history.pop();
			if(l.url.equals(url)) {
				fr = l.frequency;
				break;
			}
			helper.push(l);
		}
		while(!helper.isEmpty())
			history.push(helper.pop());
		history.push(new Link(url,++fr));
	}
	public void removeLast() {
		history.pop();
	}
	public void removeLast(String date) {
		Link l = null;
		while(!history.isEmpty()) {
			l = (Link)history.pop();
			if(!l.date.equals(date))
				helper.push(l);
		}
		while(!helper.isEmpty())
			history.push(helper.pop());
	}
	public int getNumber() {
		return (Integer)history.pop();
	}
	public String search() {
		String maxSoFar = "";
		Link l = null;
		int maxF =0 ;
		while(!history.isEmpty()) {
			l = (Link)history.pop();
			if(l.frequency>maxF) {
				maxSoFar = l.url;
				maxF = l.frequency;
			}
			helper.push(l);
		}
		while(!helper.isEmpty())
			history.push(helper.pop());
		return maxSoFar;
	}
	public void printHistory() {
		history.printStack();
	}
	public static void main(String[] args) {
		BrowsingHistory bh = new BrowsingHistory();
		bh.add("https://www.google.com/");
		bh.add("https://instagram.com/");
		bh.add("https://youtube.com/");
		bh.add("https://www.google.com/");
		//bh.printHistory();
		//System.out.println("Most viewed website: "+bh.search());
		//bh.removeLast();
		//System.out.println("Current Browsing History: ");
		//bh.printHistory();
		bh.add("https://facebok.com/");
		bh.add("https://snapchat.com/");
		bh.add("https://google.com/");
		bh.add("https://met.guc.edu.eg/");
		bh.add("https://cms.guc.edu.eg/");
		//System.out.println("Current Browsing History: ");
		//bh.printHistory();
		//System.out.println("Most viewed website: "+bh.search());
		//bh.removeLast();
		//bh.removeLast();
		//bh.printHistory();
		
	}
}
