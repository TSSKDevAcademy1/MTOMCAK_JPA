package jpa.dao;

import java.util.List;

import model.Person;
import sk.t_systems.akademia.jpa.JpaHelper;

public class PersonDao implements ObjectDao {

	@Override
	public void store(Object person) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(person);
		JpaHelper.committransaction();
	}

	@Override
	public void load() {
		JpaHelper.beginTransaction();
		List<Person> person = JpaHelper.getEntityManager().createQuery("select p from Person p", Person.class)
				.getResultList();
		for (Person p : person) {
			System.out.println(p);
		}
		JpaHelper.committransaction();
	}

	public void findPersonsByLuckyNumber(int number) {
		JpaHelper.beginTransaction();
		List<Person> persons = JpaHelper.getEntityManager()
				.createQuery("SELECT DISTINCT p FROM Person p JOIN p.luckyNumber number WHERE number = :number",
						Person.class).setParameter("number",number)
				.getResultList();
		for (Person p : persons) {
			System.out.println(p);
		}
		JpaHelper.committransaction();
	}
	
	public void findPersonByProducerCar(String producer) {
		JpaHelper.beginTransaction();
//		List<Person> persons = JpaHelper.getEntityManager()
//				.createQuery("SELECT DISTINCT p FROM Person p JOIN p.luckyNumber number WHERE number = :number",
//						Person.class).setParameter("number",number)
//				.getResultList();
//		for (Person p : persons) {
//			System.out.println(p);
		}
	//	JpaHelper.committransaction();
	}
