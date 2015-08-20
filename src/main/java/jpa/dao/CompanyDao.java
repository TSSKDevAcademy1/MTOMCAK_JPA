package jpa.dao;

import java.util.List;

import model.Company;
import sk.t_systems.akademia.jpa.JpaHelper;

public class CompanyDao implements ObjectDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see jpa.dao.ObjectLoader#store(sk.t_systems.akademia.jpa.Company)
	 */
	public void store(Object company) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(company);
		JpaHelper.committransaction();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jpa.dao.ObjectLoader#save()
	 */
	public void load() {
		JpaHelper.beginTransaction();
		List<Company> companies = JpaHelper.getEntityManager().createQuery("select c from Company c", Company.class)
				.getResultList();
		for (Company c : companies) {
			System.out.println(c);
		}
		JpaHelper.committransaction();
	}
}
