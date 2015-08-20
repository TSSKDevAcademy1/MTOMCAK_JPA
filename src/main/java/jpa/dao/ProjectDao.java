package jpa.dao;

import java.util.List;

import model.Company;
import model.Person;
import model.Project;
import sk.t_systems.akademia.jpa.JpaHelper;

public class ProjectDao implements ObjectDao {

	@Override
	public void store(Object project) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(project);
		JpaHelper.committransaction();
	}

	@Override
	public void load() {
		JpaHelper.beginTransaction();
		List<Project> projects = JpaHelper.getEntityManager().createQuery("SELECT p FROM Project p", Project.class)
				.getResultList();
		for (Project p : projects) {
			System.out.println(p);
		}
		JpaHelper.committransaction();
	}

	public void addProject(Project project) {

	}
	
	public void addPerson(Person person) {

	}
	
	public void removePerson(Person person) {

	}
	
	public void showAllProjectOfCompany(Company company) {

	}
	
}
