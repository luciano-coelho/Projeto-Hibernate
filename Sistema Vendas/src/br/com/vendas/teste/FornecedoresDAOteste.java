package br.com.vendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;

public class FornecedoresDAOteste {

	@Test
	@Ignore
	public void salvar() {

		Fornecedor f = new Fornecedor();
		f.setDescricao("Teste");

		FornecedoresDAO dao = new FornecedoresDAO();
		dao.salvar(f);

	}

	@Test
	@Ignore
	public void listar() {

		FornecedoresDAO dao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = dao.listar();

		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor f1 = dao.buscarPorCodigo(3L);
		Fornecedor f2 = dao.buscarPorCodigo(6L);

		System.out.println(f1);
		System.out.println(f2);

	}

	@Test
	@Ignore
	public void excluir() {

		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(5L);

		dao.excluir(fornecedor);
	}

	@Test
	@Ignore
	public void editar() {

		FornecedoresDAO dao = new FornecedoresDAO();

		Fornecedor fornecedor = dao.buscarPorCodigo(6L);
		fornecedor.setDescricao("Descrição Seis");

		dao.editar(fornecedor);
	}

}
