package br.com.vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.teste.HibernateUtil;

public class FuncionariosDAO {

	// Método Salvar com hibernate
	public void salvar(Funcionario funcionario) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Salvando caso transação efetuada com sucesso
			sessao.save(funcionario);

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

	// Método Para buscar Por Codigo
	public Funcionario buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			// Método para consultar valor unico
			funcionario = (Funcionario) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return funcionario;
	}

	// Método Excluir com hibernate
	public void excluir(Funcionario funcionario) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Excluindo caso transação efetuada com sucesso
			sessao.delete(funcionario);

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
	public void editar(Funcionario funcionario) {

		// Iniciando Sessão de Conexão com o BD Através do Hibernate
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Variavel de Transação
		Transaction transacao = null;

		// Verificando e tratando transação
		try {
			// Abrinda a Transação
			transacao = sessao.beginTransaction();

			// Editando caso transação efetuada com sucesso
			sessao.update(funcionario);

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
