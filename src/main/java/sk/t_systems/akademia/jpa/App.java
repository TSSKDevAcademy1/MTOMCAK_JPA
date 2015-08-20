package sk.t_systems.akademia.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jpa.dao.CompanyDao;
import jpa.dao.InvoiceDao;
import jpa.dao.PersonDao;
import jpa.dao.ProjectDao;
import model.Address;
import model.Company;
import model.DevelopProject;
import model.Gender;
import model.Invoice;
import model.Item;
import model.ManagmentProject;
import model.Person;

/**
 * Create object company and person and write into DB, using hibernate.
 *
 */
public class App {

	public static void main(String[] args) {
		/** Company dao */
		CompanyDao compDao = new CompanyDao();
		/** Person dao */
		PersonDao personDao = new PersonDao();
		/** Invoice dao */
		InvoiceDao invoiceDao = new InvoiceDao();
		/** Project dao */
		ProjectDao projectDao = new ProjectDao();
		
		/** Date format. */
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

		Company company = new Company("Nay", new Address(), 45, new Date());
		Person person = new Person("Matus",24,new Date(),Gender.MALE, company);
		
		company.addTelephoneNumbers("097883516351");
		try {
			/** Company */
			// compDao.load();

			/** Person */
			// personDao.load();
			// personDao.store(p);

//			/** Insert 10 person into the DB with specified Employer */
//			for (int i = 0; i < 10; i++) {
//				personDao.store(new Person("Jozef c. " + i + 1, 20 + i, new Date(), Gender.MALE, company));
//			}
			/** Find person in DB with specified lucky number. */
			personDao.findPersonsByLuckyNumber(3);

			/** Create date format */
			Date dueDateOf = df.parse("16.10.2007");
			Date dateOfIssuance = df.parse("15.10.2007");

			/** Create invoice */
			Invoice i = invoiceDao.newInvoice(company, "palackeho 3", dateOfIssuance, dueDateOf,
					"SK000000142548758SAK");
			i.addItem(new Item("pero", 1, 1));
			i.addItem(new Item("ceruzka", 1, 1));
			i.addItem(new Item("lepidlo", 1, 1));
			i.addItem(new Item("papier", 5, 1));

			company.addInvoices(i);
			// compDao.store(company);
			// invoiceDao.showInvoicesOfComapny(company);
			invoiceDao.showInvoicesDueDateOf(dueDateOf);
			
			/** Project */
			
			// create developer project and add technologies
			DevelopProject devP = new DevelopProject();
			devP.addTechnologies("Java");
			devP.addTechnologies("C#");
			devP.addTechnologies("C++");
			devP.setName("CT");
			devP.setStartDate(new Date());
			devP.setCompany(company);
			devP.addPerson(person);
			devP.addPerson(new Person("Jakub",28,new Date(),Gender.MALE, company));
			devP.addPerson(new Person("Viera",35,new Date(),Gender.FEMALE, company));
			devP.addPerson(new Person("Johny",25,new Date(),Gender.MALE, company));
			
			// create managment project and add description
			ManagmentProject manP = new ManagmentProject();
			manP.addDescription("Medicine project for computed tomography.");
			manP.addPerson(new Person("Viera",35,new Date(),Gender.FEMALE, company));
			manP.addPerson(new Person("Roman",15,new Date(),Gender.MALE, company));
			manP.addPerson(new Person("Anka",41,new Date(),Gender.MALE, company));
			
			projectDao.store(manP);
			projectDao.store(devP);
		
//			// add person to project 
//			person.addProject(devP);
//			person.addProject(manP);
//			
//			person.addProject(manP);
//			person.addProject(devP);
//			
//			compDao.store(company);
		} catch (ParseException e) {
			System.err.println(e);
		} finally {
			JpaHelper.close();
		}
	}
}
