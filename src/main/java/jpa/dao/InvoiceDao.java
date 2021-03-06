package jpa.dao;

import java.util.Date;
import java.util.List;

import model.Company;
import model.Invoice;
import sk.t_systems.akademia.jpa.JpaHelper;

public class InvoiceDao implements ObjectDao {

	public Invoice newInvoice(Company c, String a, Date dOI, Date dDO, String aN) {
		return new Invoice(c, a, dOI, dDO, aN);
	}

	public void showInvoicesOfComapny(Company company) {
		JpaHelper.beginTransaction();
		List<Invoice> invoices = JpaHelper.getEntityManager()
				.createQuery("SELECT i FROM Invoice i WHERE i.company = :company", Invoice.class)
				.setParameter("company", company).getResultList();
		for (Invoice i : invoices) {
			System.out.println(i);
		}
		JpaHelper.committransaction();
	}

	public void showInvoicesDueDateOf(Date date) {
		JpaHelper.beginTransaction();
		List<Invoice> invoices = JpaHelper.getEntityManager()
				.createQuery("SELECT i FROM Invoice i where i.dueDateOf = :date", Invoice.class).setParameter("date", date).getResultList();
		for (Invoice i : invoices) {
			System.out.println(i);
		}
		JpaHelper.committransaction();
	}

	public void allInvoicedCompanySpecifiedDate(Company company, Date date) {

	}

	@Override
	public void store(Object invoice) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(invoice);
		JpaHelper.committransaction();
	}

	@Override
	public void load() {
		JpaHelper.beginTransaction();
		List<Invoice> invoices = JpaHelper.getEntityManager().createQuery("SELECT i FROM Invoice i", Invoice.class)
				.getResultList();
		for (Invoice i : invoices) {
			System.out.println(i);
		}
		JpaHelper.committransaction();
	}
}
