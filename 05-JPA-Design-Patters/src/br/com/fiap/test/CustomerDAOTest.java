package br.com.fiap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CustomerDAO;
import br.com.fiap.entity.Customer;
import br.com.fiap.entity.Gender;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.SearchNotFoundException;
import br.com.fiap.impl.CustomerDAOImpl;

class CustomerDAOTest {

	private static CustomerDAO dao;
private static Customer c;
	// Metodo executado antes de todos os testes
	@BeforeAll
	public static void init() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager em = factory.createEntityManager();

		dao = new CustomerDAOImpl(em);
	}

	
	
	@BeforeEach

	void beforeTest() {
			// Arrage - instaciar os objetos

			Customer c = new Customer("Teste", new GregorianCalendar(1999, Calendar.MARCH, 15), Gender.FEMININO, null);
			// cadastrar cliente
			// Act-cadastrar o cliente
			dao.create(c);
			try {
				dao.commit();
			} catch (CommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Falha no teste");
			}

			// Assert - validar o resultado
			assertNotEquals(c.getId(), 0);
			// valida se gerou um codigo pro cliente
		
	}
	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {
		
		// Assert - validar o resultado
		assertNotEquals(c.getId(), 0);
		
	}

	@Test
	@DisplayName("Teste de busca com sucesso")
	void read() {
		// Arrange - instanciar os objetos e o cadastro
		Customer c = new Customer("Teste", new GregorianCalendar(1999, Calendar.MARCH, 15), Gender.FEMININO,
				null);
		try {
			dao.create(c);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		// Act - pesquisar o customer que foi cadastrado
		try {
			Customer search = dao.read(c.getId());
			// Assert - valida se pesquisou corretamente
			assertNotNull(search);
			assertEquals(search.getId(), c.getId());
		} catch (SearchNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}

	}

	@Test
	@DisplayName("Teste de atualização feito com sucesso")
	void update() {
		// cadastrar um customer
		// Arrage - instaciar os objetos

		// cadastrar cliente
		// Act-cadastrar o cliente
		dao.create(c);
		try {
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Falha no teste");
		}

		// Assert - validar o resultado
		assertNotEquals(c.getId(), 0);
		// valida se gerou um codigo pro cliente
		c.setName("Teste");
		c.setGender(Gender.FEMININO);
		try {
			dao.update(c);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}

		// atualizar o customer cadastrado

		// pesquisa ro customer

		// validar se as alteracoes forma realizadas

	}

	@Test
	@DisplayName("Teste de delete feito com sucesso")

	void delete() {



		try {
			dao.delete(c.getId());
			dao.commit();
		} catch (SearchNotFoundException  | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		} 
		//pesquisa
		Customer search = null;
		try {
			search = dao.read(c.getId());
			fail("Falha no teste");		
			}catch(SearchNotFoundException e) {
				assertNull(search);
			}
	}
}
