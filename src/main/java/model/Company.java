package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Company {
	
	public Company(String name, Address address, int employeesCount, Date founded) {
		super();
		this.name = name;
		this.address = address;
		this.employeesCount = employeesCount;
		this.founded = founded;
	}
	
	public Company() {
		super();
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private int employeesCount;
	
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Invoice> invoices = new ArrayList<>();

	@Temporal(TemporalType.DATE)
	private Date founded;
	
	@ElementCollection (fetch = FetchType.LAZY)
	private List<String> telephoneNumbers = new ArrayList<>();
	
	@OneToMany
	private List<Person> employees = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getEmployeesCount() {
		return employeesCount;
	}

	public void setEmployeesCount(int employeesCount) {
		this.employeesCount = employeesCount;
	}

	public Date getFounded() {
		return founded;
	}

	public void setFounded(Date founded) {
		this.founded = founded;
	}
	
	public List<String> getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public void addTelephoneNumbers(String telNumber) {
		telephoneNumbers.add(telNumber);
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	public void addInvoices(Invoice invoice) {
		this.invoices.add(invoice);
	}
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", employeesCount=" + employeesCount + ", founded="
				+ founded + "]";
	}
}
