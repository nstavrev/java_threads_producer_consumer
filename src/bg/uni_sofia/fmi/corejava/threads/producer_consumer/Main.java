package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	
	public static void main(String[] args) {
		
		Collection<Product> store = new ArrayList<Product>();
		
		Thread[] producers = new Thread[100];
		Thread[] consumers = new Thread[100];
		
		for(int i=0; i<producers.length; i++){
			producers[i] = new Producer(store);
		}
		
		for(int j=0; j<consumers.length; j++){
			consumers[j] = new Consumer(store);
		}
		
		try {
			
			for(int i=0; i<producers.length; i++){
				producers[i].start();
				producers[i].join();
				consumers[i].start();
				consumers[i].interrupt();
				consumers[i].join();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	}

}
