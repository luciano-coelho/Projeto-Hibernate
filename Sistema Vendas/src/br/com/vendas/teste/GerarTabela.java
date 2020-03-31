package br.com.vendas.teste;

public class GerarTabela {

	public static void main(String[] args) {

		try {
			HibernateUtil.getSessionFactory();
			HibernateUtil.getSessionFactory().close();
		
		} catch (Exception e) {
			System.out.println("Erro:"+e);
			
		}

	}

}
