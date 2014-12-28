package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import java.util.Collection;

public class Consumer extends Thread{
	
	private Collection<Product> store;
	
	public Consumer(Collection<Product> store) {
		this.store = store;
	}
	
	private void consume(Product product) {
		System.out.println("consuming product");
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (store) {
				for (Product product : store) {
					this.consume(product);
				}
				store.clear();
				try {
					store.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
