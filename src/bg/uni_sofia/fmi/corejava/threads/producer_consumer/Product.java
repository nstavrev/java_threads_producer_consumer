package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	private long id;
	
	@Column
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
