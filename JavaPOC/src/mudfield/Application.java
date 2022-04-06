package mudfield;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String args[]) {
		List<Integer> myIntList = new ArrayList();
		int one = 1;
		Integer two = new Integer(2);
		myIntList.add(one);
		myIntList.add(two);
		System.out.println("Print list = " + myIntList.toString());

		List<Store> stores = new ArrayList();
		Store walmart = new Store("Walmart", "123 Whitestone Blvd");
		stores.add(walmart);

		Store costco = new Store("Costco", "3000 US183");
		stores.add(costco);

		System.out.println("Print stores = " + stores.toString());

	}
}
