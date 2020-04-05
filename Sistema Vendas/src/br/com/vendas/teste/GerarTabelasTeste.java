package br.com.vendas.teste;

import org.junit.Ignore;
import org.junit.Test;

public class GerarTabelasTeste {
	
	@Test
	@Ignore
	public void gerar() {
		
		HibernateUtil.getSessionFactory();
		System.out.println("Conectado");
		HibernateUtil.getSessionFactory().close();
	}
	
}
