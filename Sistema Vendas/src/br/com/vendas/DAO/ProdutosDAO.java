package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.domain.Produto;
import br.com.vendas.teste.HibernateUtil;

public class ProdutosDAO {
	

	// M�todo Salvar com hibernate
	public void salvar(Produto produto) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Salvando caso transa��o efetuada com sucesso
			sessao.save(produto);

			// Confirmando a Transa��o
			transacao.commit();

		} catch (RuntimeException ex) {
			// Verificar se transa��o diferente de null e cont�m erro desfazer
			if (transacao != null) {
				transacao.rollback();
			}

		}

		finally {
			// Fechando e finalizando conex�o
			sessao.close();
		}

	}

	// M�todo Para Listar
	@SuppressWarnings("unchecked") // Desabilita consulta caso n�o encotre nada
	public List<Produto> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Produto> listaProdutos = null;

		try {

			// Criar Query de consulta para receber NamedQuery
			Query consulta = sessao.getNamedQuery("Produto.listar");
			// Listar Dados
			listaProdutos = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return listaProdutos;
	}

	// M�todo Para buscar Por Codigo
	public Produto buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Produto produto = null;

		try {

			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			// M�todo para consultar valor unico
			produto = (Produto) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return produto;
	}

	// M�todo Excluir com hibernate
	public void excluir(Produto produto) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Excluindo caso transa��o efetuada com sucesso
			sessao.delete(produto);

			// Confirmando a Transa��o
			transacao.commit();

		} catch (RuntimeException ex) {
			// Verificar se transa��o diferente de null e cont�m erro desfazer
			if (transacao != null) {
				transacao.rollback();
			}

		}

		finally {
			// Fechando e finalizando conex�o
			sessao.close();
		}

	}

	// M�todo Editar com hibernate
	public void editar(Produto produto) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Editando caso transa��o efetuada com sucesso
			sessao.update(produto);

			// Confirmando a Transa��o
			transacao.commit();

		} catch (RuntimeException ex) {
			// Verificar se transa��o diferente de null e cont�m erro desfazer
			if (transacao != null) {
				transacao.rollback();
			}

		}

		finally {
			// Fechando e finalizando conex�o
			sessao.close();
		}

	}

}
