package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.teste.HibernateUtil;

public class FornecedoresDAO {

	// M�todo Salvar com hibernate
	public void salvar(Fornecedor fornecedor) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Salvando caso transa��o efetuada com sucesso
			sessao.save(fornecedor);

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

	// M�todo Para buscar Por Codigo
	public Fornecedor buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			// M�todo para consultar valor unico
			fornecedor = (Fornecedor) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return fornecedor;
	}

	// M�todo Excluir com hibernate
	public void excluir(Fornecedor fornecedor) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Excluindo caso transa��o efetuada com sucesso
			sessao.delete(fornecedor);

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
	public void editar(Fornecedor fornecedor) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Editando caso transa��o efetuada com sucesso
			sessao.update(fornecedor);

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

}// Fechamento da Classe
