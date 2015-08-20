package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private long id;

	public Invoice() {
		super();
	}

	public Invoice(Company company, String addressee, Date dateOfIssuance, Date dueDateOf,
			String accountNumber) {
		super();
		this.company = company;
		this.addressee = addressee;
		this.dateOfIssuance = dateOfIssuance;
		this.dueDateOf = dueDateOf;
		this.accountNumber = accountNumber;
		this.totalPrice = 0;
	}

	/** Company. */
	@ManyToOne
	private Company company;
	/** Person address. */
	private String addressee;
	/** Item list. */
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> items = new ArrayList<>();
	/** Date of issuance. */
	private Date dateOfIssuance;
	/** The due date. */
	private Date dueDateOf;
	/** Account number of person */
	private String accountNumber;
	/** Sum price of all item. */
	private double totalPrice;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		this.totalPrice = 0;
		/** Total price of items */
		items.add(item);
		for (Item i : items) {
			this.totalPrice += i.getCount() * i.getPrice();
		}
	}

	public Date getDateOfIssuance() {
		return dateOfIssuance;
	}

	public void setDateOfIssuance(Date dateOfIssuance) {
		this.dateOfIssuance = dateOfIssuance;
	}

	public Date getDueDateOf() {
		return dueDateOf;
	}

	public void setDueDateOf(Date dueDateOf) {
		this.dueDateOf = dueDateOf;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "Invoice [company=" + company + ", addressee=" + addressee + ", items=" + items + ", dateOfIssuance="
				+ dateOfIssuance + ", dueDateOf=" + dueDateOf + ", accountNumber=" + accountNumber + ", totalPrice="
				+ totalPrice + "]";
	}
}
