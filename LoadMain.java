package emp;


//import org.hibernate.AnnotationCongiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class LoadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session6=new Configuration(). 
				configure("hibernate.cfg.xml").buildSessionFactory()
				.openSession();
		Transaction tx = session6.beginTransaction();
		Employee emp = (Employee) session6.load(Employee.class, 23);
		System.out.println("Employee object loaded. " + emp);
		tx.commit();

		 //merge example - data already present in tables
		 emp.setEmpAddress("delhi");
		 Transaction tx8 = session6.beginTransaction();
		 Employee emp4 = (Employee) session6.merge(emp);
		 System.out.println(emp4 == emp); // returns false
		 emp4.setEmpName("suraj");
		 emp4.setEmpAddress("mangalore");
		 System.out.println(" Before committing merge transaction");
		 tx8.commit();
				session6.close();
		}



	}


