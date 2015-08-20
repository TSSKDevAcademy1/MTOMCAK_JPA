package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class ManagmentProject extends Project {
	
	@Column(length = 5000)
	String description = "";

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addDescription(String addDescription)
	{
		description += addDescription;
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
	
	public void addCompany(){
		
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
	public String toString() {
		return "ManagmentProject [id=" + id + ", description=" + description + ", name=" + name + "]";
	}
}
