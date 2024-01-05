package Assignment6;
public class SuperMarket {
	PriorityQueue pq;
	public SuperMarket(int size) {
		pq = new PriorityQueue(size);
	}
	public double newPrice(int proId) {
		double res = -1;
		int cnt = -1;
		StackObj tmp = new StackObj(pq.size());
		while(!pq.isEmpty()) {
			YoghurtProduct y = (YoghurtProduct) pq.remove();
			if(tmp.isEmpty() 
			|| ((YoghurtProduct)tmp.top()).date.isEqual(y.date))
				cnt++;
			if(y.id==proId) {
				res = y.price;
				break;
			}
			else
				tmp.push(y);
		}
		int discount = 50 - (5*cnt);
		res = res - (res*(discount/100));
		while(!tmp.isEmpty())
			pq.insert((Comparable)tmp.pop());
		return res;
	}
}
