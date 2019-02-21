package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	public static void main(String[] args) {
		// Criar um gerenciador de entidades

		// Primerio criar a fabrica de entity manager //nome que ta no persistence.xml
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		// Criar entity manager
		EntityManager em = fabrica.createEntityManager();
		fabrica.close();
	}
}
