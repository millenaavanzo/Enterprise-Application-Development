package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	//atributo
	private static EntityManagerFactory fabrica;
	
	
	//construtor
	public EntityManagerFactorySingleton() {
		
	}
	
	//metodo
	public static EntityManagerFactory getInstance() {
		if(fabrica==null) {
			fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
}
