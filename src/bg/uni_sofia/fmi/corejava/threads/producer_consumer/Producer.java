package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import java.util.Collection;
import java.util.Random;

public class Producer extends Thread {
	
	private Collection<Product> store;
	
	public Producer(Collection<Product> store) {
		this.store = store;
	}
	
	private Product produce() {
		Product newProduct = new Product("product" + new Random(System.currentTimeMillis()).nextInt());
//		System.out.println("Създаване на продукт с id " + newProduct.getId() + " от нишка " + Thread.currentThread().getName());
		return newProduct;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<Constants.MAX_PRODUCTS; i++){
			Product newProduct = this.produce();
			synchronized (store) {
				store.add(newProduct);
				store.notifyAll();
			}
			
		}
		
	}
	
}
