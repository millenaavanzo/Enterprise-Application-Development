package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Genero;
import br.com.fiap.bean.Pessoa;

public class Teste {
	public static void main (String[]args) {
		Pessoa p = new Pessoa();
		p.setSexo(Genero.FEMININO);
		
		Calendar data = Calendar.getInstance(); //DATA ATUAL
		Calendar data2 = new GregorianCalendar(2000, Calendar.MARCH, 01); //ANO, MES,DIA	
		
		p.setDataNascimento(data);
		
		//FORMATAR DATA PRA EXIBIR - CALENDAR
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // MM tem que ser maiusculo, mm minusculo são os minutos 
		System.out.println(sdf.format(data.getTime()));
		//DATA 2
		System.out.println(sdf.format(data2.getTime()));
		
	}
}
