package br.com.vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.teste.HibernateUtil;

public class FuncionariosDAO {

	// M�todo Salvar com hibernate
	public void salvar(Funcionario funcionario) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Salvando caso transa��o efetuada com sucesso
			sessao.save(funcionario);

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
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionario> listaFuncionario = null;

		try {

			// Criar Query de consulta para receber NamedQuery
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			// Listar Dados
			listaFuncionario = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return listaFuncionario;
	}

	// M�todo Para buscar Por Codigo
	public Funcionario buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			// M�todo para consultar valor unico
			funcionario = (Funcionario) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return funcionario;
	}

	// M�todo Excluir com hibernate
	public void excluir(Funcionario funcionario) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Excluindo caso transa��o efetuada com sucesso
			sessao.delete(funcionario);

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
	public void editar(Funcionario funcionario) {

		// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transa��o
		Transaction transacao = null;

		// Verificando e tratando transa��o
		try {
			// Abrinda a Transa��o
			transacao = sessao.beginTransaction();

			// Editando caso transa��o efetuada com sucesso
			sessao.update(funcionario);

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
