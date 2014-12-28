package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	
	public static void main(String[] args) {
		
		Collection<Product> store = new ArrayList<Product>();
		Thread producer = new Producer(store);
		Thread consumer = new Consumer(store);
		producer.start();
		consumer.start();
        
	}

}
