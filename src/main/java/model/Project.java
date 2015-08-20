package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
public abstract class Project {
    @Id
    @GeneratedValue
    public long id;
    
	/** Company. */
	@ManyToOne
	private Company company;
	
	/** Person. */
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "projects")
	List<Person> person = new ArrayList<>();
    
	public String name;
	private Date startDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	
	public void addPerson(Person person)
	{
		this.person.add(person);
	}	
}
