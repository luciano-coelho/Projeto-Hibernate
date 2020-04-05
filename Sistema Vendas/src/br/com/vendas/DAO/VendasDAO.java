package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.domain.Vendas;
import br.com.vendas.teste.HibernateUtil;

public class VendasDAO {

	// Método Salvar com hibernate
		public void salvar(Vendas vendas) {

			// Iniciando Sessão de Conexão com o BD Através do Hibernate
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			// Variavel de Transação
			Transaction transacao = null;

			// Verificando e tratando transação
			try {
				// Abrinda a Transação
				transacao = sessao.beginTransaction();

				// Salvando caso transação efetuada com sucesso
				sessao.save(vendas);

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
		public List<Vendas> listar() {
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			List<Vendas> listaVendas = null;

			try {

				// Criar Query de consulta para receber NamedQuery
				Query consulta = sessao.getNamedQuery("Vendas.listar");
				// Listar Dados
				listaVendas = consulta.list();

			} catch (RuntimeException ex) {
				throw ex;
			}

			finally {
				sessao.close();
			}

			return listaVendas;
		}

		// Método Para buscar Por Codigo
		public Vendas buscarPorCodigo(Long codigo) {

			Session sessao = HibernateUtil.getSessionFactory().openSession();

			Vendas vendas = null;

			try {

				Query consulta = sessao.getNamedQuery("Vendas.buscarPorCodigo");
				consulta.setLong("codigo", codigo);
				// Método para consultar valor unico
				vendas = (Vendas) consulta.uniqueResult();

			} catch (RuntimeException ex) {
				throw ex;
			}

			finally {
				sessao.close();
			}

			return vendas;
		}

		// Método Excluir com hibernate
		public void excluir(Vendas vendas) {

			// Iniciando Sessão de Conexão com o BD Através do Hibernate
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			// Variavel de Transação
			Transaction transacao = null;

			// Verificando e tratando transação
			try {
				// Abrinda a Transação
				transacao = sessao.beginTransaction();

				// Excluindo caso transação efetuada com sucesso
				sessao.delete(vendas);

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
		public void editar(Vendas vendas) {

			// Iniciando Sessão de Conexão com o BD Através do Hibernate
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			// Variavel de Transação
			Transaction transacao = null;

			// Verificando e tratando transação
			try {
				// Abrinda a Transação
				transacao = sessao.beginTransaction();

				// Editando caso transação efetuada com sucesso
				sessao.update(vendas);

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
