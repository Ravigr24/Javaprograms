package sortinglogic;

import java.util.Comparator;

import com.jspiders.Product;

public class sortProductByCost implements Comparator<Product>{

	@Override
	public int compare(Product x, Product y) {
		
		return x.getCost()-y.getCost();
	}

}
