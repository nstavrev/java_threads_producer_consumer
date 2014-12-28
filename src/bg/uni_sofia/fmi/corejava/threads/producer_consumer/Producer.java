package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import java.util.Collection;
import java.util.Random;

public class Producer extends Thread {

	private Collection<Product> store;

	public Producer(Collection<Product> store) {
		this.store = store;
	}

	private Product produce() {
		System.out.println("Producing product");
		Product newProduct = new Product("product"
				+ new Random(System.currentTimeMillis()).nextInt());
		Util.saveProduct(newProduct);
		return newProduct;
	}

	@Override
	public void run() {

		while (true) {
			Product newProduct = this.produce();
			synchronized (store) {
				store.add(newProduct);
				store.notifyAll();
			}

		}

	}

}
