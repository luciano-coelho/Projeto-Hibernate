package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.vendas.domain.Vendas;
import br.com.vendas.teste.HibernateUtil;

public class VendasDAO {

	// M�todo Salvar com hibernate
		public void salvar(Vendas vendas) {

			// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			// Variavel de Transa��o
			Transaction transacao = null;

			// Verificando e tratando transa��o
			try {
				// Abrinda a Transa��o
				transacao = sessao.beginTransaction();

				// Salvando caso transa��o efetuada com sucesso
				sessao.save(vendas);

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

		// M�todo Para buscar Por Codigo
		public Vendas buscarPorCodigo(Long codigo) {

			Session sessao = HibernateUtil.getSessionFactory().openSession();

			Vendas vendas = null;

			try {

				Query consulta = sessao.getNamedQuery("Vendas.buscarPorCodigo");
				consulta.setLong("codigo", codigo);
				// M�todo para consultar valor unico
				vendas = (Vendas) consulta.uniqueResult();

			} catch (RuntimeException ex) {
				throw ex;
			}

			finally {
				sessao.close();
			}

			return vendas;
		}

		// M�todo Excluir com hibernate
		public void excluir(Vendas vendas) {

			// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			// Variavel de Transa��o
			Transaction transacao = null;

			// Verificando e tratando transa��o
			try {
				// Abrinda a Transa��o
				transacao = sessao.beginTransaction();

				// Excluindo caso transa��o efetuada com sucesso
				sessao.delete(vendas);

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
		public void editar(Vendas vendas) {

			// Iniciando Sess�o de Conex�o com o BD Atrav�s do Hibernate
			Session sessao = HibernateUtil.getSessionFactory().openSession();

			// Variavel de Transa��o
			Transaction transacao = null;

			// Verificando e tratando transa��o
			try {
				// Abrinda a Transa��o
				transacao = sessao.beginTransaction();

				// Editando caso transa��o efetuada com sucesso
				sessao.update(vendas);

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
