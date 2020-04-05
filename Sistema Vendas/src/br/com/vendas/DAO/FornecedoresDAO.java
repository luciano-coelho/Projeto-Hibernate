package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.teste.HibernateUtil;

public class FornecedoresDAO {

	// Método Salvar com hibernate
	public void salvar(Fornecedor fornecedor) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Salvando caso transação efetuada com sucesso
			sessao.save(fornecedor);

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
	public List<Fornecedor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Fornecedor> listaFornecedores = null;

		try {

			// Criar Query de consulta para receber NamedQuery
			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			// Listar Dados
			listaFornecedores = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return listaFornecedores;
	}

	// Método Para buscar Por Codigo
	public Fornecedor buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			// Método para consultar valor unico
			fornecedor = (Fornecedor) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return fornecedor;
	}

	// Método Excluir com hibernate
	public void excluir(Fornecedor fornecedor) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Excluindo caso transação efetuada com sucesso
			sessao.delete(fornecedor);

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
	public void editar(Fornecedor fornecedor) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Editando caso transação efetuada com sucesso
			sessao.update(fornecedor);

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

}// Fechamento da Classe
