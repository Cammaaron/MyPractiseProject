package revature.revatureHibernateExample.driver;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import revature.revatureHibernateExample.model.Bear;
import revature.revatureHibernateExample.model.Cave;
import revature.revatureHibernateExample.model.HoneyPot;
import revature.revatureHibernateExample.util.HibernateUtil;

public class Driver {

	
	public static void main(String[] args){
		Session session = HibernateUtil.getSession();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println("Closing Session");
		HoneyPot hp = (HoneyPot) session.get(HoneyPot.class, 50);
		System.out.println(hp.toString());
		
		Bear b = (Bear) session.get(Bear.class, 50);
		System.out.println(b.toString());
		
		Cave c = (Cave) session.get(Cave.class, 50);
		System.out.println(c.toString());*/
		
		//Criteria
		
		Criteria cr = session.createCriteria(Bear.class);
		cr.add(Restrictions.between("id", 1, 1000));
		cr.add(Restrictions.ilike("bearBreed", "brown bear"));
		cr.add(Restrictions.isEmpty("bearCubs"));
		
		List rs = cr.list(); 
		
		System.out.println(rs);
		System.out.println("Size was " + rs.size());
		
		
		/*
		Query q = session.createQuery("from Bear where id = :id");
		q.setParameter("id", 50);
		List list = q.list();
		System.out.println(list);
		*/
		
		session.close();
	}
}
