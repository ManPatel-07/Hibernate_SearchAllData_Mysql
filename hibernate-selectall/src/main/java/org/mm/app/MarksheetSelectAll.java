package org.mm.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mm.model.Marksheet;

public class MarksheetSelectAll {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

		SessionFactory sf = new MetadataSources(registry)
		.buildMetadata()
		.buildSessionFactory();
		
		Session s = sf.openSession();
		
		List li = s.createQuery("from Marksheet").list();
		
		Iterator ite = li.iterator();
		
		while(ite.hasNext())
		{
			Marksheet m = (Marksheet) ite.next();
			
			System.out.println(m.getName());
			
		}
		
		s.close();

	}

}
