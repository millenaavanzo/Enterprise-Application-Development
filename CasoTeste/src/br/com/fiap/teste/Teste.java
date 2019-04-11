package br.com.fiap.teste;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.fap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;

class Teste {

	@Test
	void test() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl();
 Usuario usuario = new Usuario();
 usuario.set
 
	}

}
