package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Person {

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, Date birthDay, Gender gender, Company company) {
		super();
		this.name = name;
		this.age = age;
		this.birthDay = birthDay;
		this.gender = gender;
		this.employer = company;

		Random rn = new Random();

		// generate 3 lucky numbers
		for (int i = 0; i < 3; i++) {
			luckyNumber.add(rn.nextInt(13) + 1);
		}
	}

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@Transient
	private int age;

	@Temporal(TemporalType.DATE)
	private Date birthDay;

	private Gender gender;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private Company employer;
	
	@OneToOne
	private Car car;
	
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}
	
	public Company getEmployer() {
		return employer;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	@ElementCollection
	private List<Integer> luckyNumber = new ArrayList<>();

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", " + (name != null ? "name=" + name + ", " : "") + "age=" + age + ", "
				+ (birthDay != null ? "birthDay=" + birthDay + ", " : "") + (gender != null ? "gender=" + gender : "")
				+ "]" + "Employer=" + employer;
	}
}
