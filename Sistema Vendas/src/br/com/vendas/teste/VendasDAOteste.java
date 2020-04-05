package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Vendas;

public class VendasDAOteste {

	@Test
	@Ignore
	public void salvar() {

		FuncionariosDAO daofuncionario = new FuncionariosDAO();
		Funcionario funcionario = daofuncionario.buscarPorCodigo(4L);

		Vendas v1 = new Vendas();

		v1.setHorario(new Date());
		v1.setValor_total(new BigDecimal(10.00D));
		v1.setFuncionario(funcionario);

		VendasDAO dao = new VendasDAO();
		dao.salvar(v1);

	}

	@Test
	@Ignore
	public void listar() {

		VendasDAO dao = new VendasDAO();
		List<Vendas> vendas = dao.listar();

		System.out.println(vendas);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO dao = new VendasDAO();
		Vendas v1 = dao.buscarPorCodigo(3L);

		System.out.println(v1);

	}

	@Test
	@Ignore
	public void excluir() {

		VendasDAO dao = new VendasDAO();
		Vendas vendas = dao.buscarPorCodigo(2L);

		dao.excluir(vendas);
	}

	@Test
	@Ignore
	public void editar() {

		FuncionariosDAO daofuncionario = new FuncionariosDAO();
		Funcionario funcionario = daofuncionario.buscarPorCodigo(1L);

		VendasDAO dao = new VendasDAO();

		Vendas v1 = dao.buscarPorCodigo(1L);
		v1.setHorario(new Date());
		v1.setValor_total(new BigDecimal(25.00D));
		v1.setFuncionario(funcionario);


		dao.editar(v1);
	}

}
