package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class DevelopProject extends Project {

	@ElementCollection
	private List<String> technologies = new ArrayList<>();

	
	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	public void addTechnologies(String technologie) {
		technologies.add(technologie);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return super.getStartDate();
	}

	@Override
	public void setStartDate(Date startDate) {
		// TODO Auto-generated method stub
		super.setStartDate(startDate);
	}

	@Override
	public Company getCompany() {
		// TODO Auto-generated method stub
		return super.getCompany();
	}

	@Override
	public void setCompany(Company company) {
		// TODO Auto-generated method stub
		super.setCompany(company);
	}

	@Override
	public List<Person> getPerson() {
		// TODO Auto-generated method stub
		return super.getPerson();
	}

	@Override
	public void setPerson(List<Person> person) {
		// TODO Auto-generated method stub
		super.setPerson(person);
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		super.addPerson(person);
	}

	@Override
	public String toString() {
		return "DevelopProject [id=" + id + ", technologies=" + technologies + ", name=" + name + "]";
	}
}
