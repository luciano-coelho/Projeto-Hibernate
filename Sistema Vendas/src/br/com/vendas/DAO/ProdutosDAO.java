package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.domain.Produto;
import br.com.vendas.teste.HibernateUtil;

public class ProdutosDAO {
	

	// Método Salvar com hibernate
	public void salvar(Produto produto) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Salvando caso transação efetuada com sucesso
			sessao.save(produto);

			// Confirmando a Transação
			transacao.commit();

		} catch (RuntimeException ex) {
			// Verificar se transação diferente de null e contém erro desfazer
			if (transacao != null) {
				transacao.rollback();
			}

		}

		finally {
			// Fechando e finalizando conexão
			sessao.close();
		}

	}

	// Método Para Listar
	@SuppressWarnings("unchecked") // Desabilita consulta caso não encotre nada
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

	// Método Para buscar Por Codigo
	public Produto buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Produto produto = null;

		try {

			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			// Método para consultar valor unico
			produto = (Produto) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return produto;
	}

	// Método Excluir com hibernate
	public void excluir(Produto produto) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Excluindo caso transação efetuada com sucesso
			sessao.delete(produto);

			// Confirmando a Transação
			transacao.commit();

		} catch (RuntimeException ex) {
			// Verificar se transação diferente de null e contém erro desfazer
			if (transacao != null) {
				transacao.rollback();
			}

		}

		finally {
			// Fechando e finalizando conexão
			sessao.close();
		}

	}

	// Método Editar com hibernate
	public void editar(Produto produto) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Editando caso transação efetuada com sucesso
			sessao.update(produto);

			// Confirmando a Transação
			transacao.commit();

		} catch (RuntimeException ex) {
			// Verificar se transação diferente de null e contém erro desfazer
			if (transacao != null) {
				transacao.rollback();
			}

		}

		finally {
			// Fechando e finalizando conexão
			sessao.close();
		}

	}

}
