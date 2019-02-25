package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizaTeste {

	public static void main(String[] args) {
EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
EntityManager em = fabrica.createEntityManager();


em.close();
fabrica.close();
	}

}
