package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

public class Product {
	
	private long id;
	
	private String name;

	public Product(String name) {
		this.id = Util.generateUniqueId();
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
