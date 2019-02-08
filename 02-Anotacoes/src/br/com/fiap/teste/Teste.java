package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Animal;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um animal
		Animal a = new Animal();
		
		
		//API Reflection : recupera toda a estrutura da classe
		
		//Exbir nome da classe
		System.out.println(a.getClass().getSimpleName());
		
		//recuperar os metodos
		System.out.println("Métodos: ");
		Method[] metodos = a.getClass().getDeclaredMethods();
		
		for(Method m:metodos) {
			System.out.println(m.getName());
		}
		
		//recuperar os atributos da classe animal
		System.out.println("Atributos: ");
		
		Field[] atributos = a.getClass().getDeclaredFields();
		
		
		for(int i=0;i<atributos.length;i++) {
			System.out.println(atributos[i].getName());
			//recuperar anotação @Coluna
			Coluna c = atributos[i].getAnnotation(Coluna.class);
			System.out.println("Campo: "+c.nome());
			System.out.println("Obrigatório: "+c.nullable());;

		}
		
		
		Tabela t = a.getClass().getAnnotation(Tabela.class);
		System.out.println("SELECT * FROM " + t.nome()  );
		
		
		
		
		
	}

}
