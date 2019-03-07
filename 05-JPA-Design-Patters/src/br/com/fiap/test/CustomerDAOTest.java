package br.com.fiap.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CustomerDAO;
import br.com.fiap.entity.Customer;
import br.com.fiap.entity.Gender;
import br.com.fiap.exception.CommitException;
import br.com.fiap.impl.CustomerDAOImpl;

class CustomerDAOTest {

	@Test
	void createTest() {
		//Arrage - instaciar os objetos
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager em = factory.createEntityManager();
		
		CustomerDAO dao = new CustomerDAOImpl(em);
		
		Customer c = new Customer("Teste",new GregorianCalendar(1999,Calendar.MARCH, 15),
				Gender.FEMININO,null);
		//cadastrar cliente
		//Act-cadastrar o cliente
		dao.create(c);
		try {
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Falha no teste");
		}
		
		//Assert - validar o resultado
		assertNotEquals(c.getId(),0);
		//valida se gerou um codigo pro cliente
	}

}
