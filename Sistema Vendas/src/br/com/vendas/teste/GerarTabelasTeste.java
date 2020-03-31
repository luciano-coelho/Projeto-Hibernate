package br.com.vendas.teste;

import org.junit.Test;

public class GerarTabelasTeste {
	
	@Test
	public void gerar() {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
}
