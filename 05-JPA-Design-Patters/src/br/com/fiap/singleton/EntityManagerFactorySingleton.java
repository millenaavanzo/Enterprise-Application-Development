package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	// 1- Atributo est�tico do objeto �nico
	
	private static EntityManagerFactory emf; 
	
	//2- Construtor privado
	private EntityManagerFactorySingleton() {
}
	//3- Metodo estatico que instancia o objeto unico
	//CONFIGURACAO DO PERSISTENCE XML QUE FAZ CONEX�O COM O BANCO DE DADOS 
	public static EntityManagerFactory getInstance() {
		if(emf== null) {
			emf=Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
	
	
}