package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMSingleton {
	
	private static EntityManagerFactory factory;
	
	private EMSingleton() { }
	
	public static EntityManagerFactory getInstance(){
		
		if (factory == null){
			factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		
		return factory;
	}
}
