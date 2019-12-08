package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
		      try {
		        // Create registry
		    	   registry = new StandardServiceRegistryBuilder().configure().build();

		        // Create MetadataSources
		        MetadataSources sources = new MetadataSources(registry);

		        // Create Metadata
		        Metadata metadata = sources.getMetadataBuilder().build();

		        // Create SessionFactory
		        sessionFactory = metadata.getSessionFactoryBuilder().build();

		      } catch (Exception e) {
		        e.printStackTrace();
		        if (registry != null) {
		          StandardServiceRegistryBuilder.destroy(registry);
		        }
		      }
		    }
		    return sessionFactory;
	}
	
    //invoke this method to get an instance of an object implementing Session
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}


Session s = HibernateUtil.getSession();
// Once a session is obtained, a variety of session methods can be invoked to perform operations on our DB
// save, persist
// get, load
// update, merge
// getCriteriaBuilder
// createQuery
// beginTransaction