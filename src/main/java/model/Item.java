package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private long id;
	/**Item name*/
	private String name;
	/**Item count*/
	private int count;
	/**Item price*/
	private double price;
	
	public Item(String name, int count, double price) {
		super();
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	public Item() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", count=" + count + ", price=" + price + "]";
	}
	
	
}
