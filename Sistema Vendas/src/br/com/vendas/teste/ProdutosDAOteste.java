package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Produto;

public class ProdutosDAOteste {

	@Test
	@Ignore
	public void salvar() {

		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(2L);

		Produto f1 = new Produto();
		f1.setDescricao("Banana");
		f1.setPreco(new BigDecimal(8.99));
		f1.setQuantidade(4);
		f1.setFornecedor(fornecedor);

		ProdutosDAO produtosdao = new ProdutosDAO();
		produtosdao.salvar(f1);

	}

	@Test
	@Ignore
	public void listar() {

		ProdutosDAO dao = new ProdutosDAO();
		List<Produto> produtos = dao.listar();

		System.out.println(produtos);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutosDAO dao = new ProdutosDAO();
		Produto f1 = dao.buscarPorCodigo(3L);

		System.out.println(f1);

	}

	@Test
	@Ignore
	public void excluir() {

		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = dao.buscarPorCodigo(4L);

		dao.excluir(produto);
	}
	
	@Test
	@Ignore
	public void editar() {

		FornecedoresDAO daofornecedor = new FornecedoresDAO();
		Fornecedor fornecedor = daofornecedor.buscarPorCodigo(5L);

		ProdutosDAO dao = new ProdutosDAO();
		
		Produto produto = dao.buscarPorCodigo(2L);
		produto.setDescricao("Morango");
		produto.setPreco(new BigDecimal(8.99));
		produto.setQuantidade(4);
		produto.setFornecedor(fornecedor);
		
		dao.editar(produto);
	}

}
