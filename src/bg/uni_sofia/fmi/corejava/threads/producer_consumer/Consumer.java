package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import java.util.Collection;
import java.util.Iterator;

public class Consumer extends Thread {

	private Collection<Product> store;

	public Consumer(Collection<Product> store) {
		this.store = store;
	}

	private void consume(Product product) throws InterruptedException {
		System.out.println("Консумация на продукт с id " + product.getId()
				+ " от нишка " + Thread.currentThread().getName());
		// Util.performSomeProcessing(1);
	}

	@Override
	public void run() {
		boolean interrupted = false;
		while (true) {
			synchronized (store) {
				Iterator<Product> i = store.iterator();
				while (i.hasNext()) {
					try {
						this.consume(i.next());
					} catch (InterruptedException e) {
						interrupted = true;
					}
					i.remove();
				}

				if (interrupted) {
					return;
				}

				try {
					store.wait();
				} catch (InterruptedException e) {
					interrupted = true;
				}
			}
		}
	}

}
