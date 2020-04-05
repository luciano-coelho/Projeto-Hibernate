package br.com.vendas.teste;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.domain.Funcionario;

public class FuncionarioDAOteste {

	@Test
	@Ignore
	public void salvar() {

		Funcionario f1 = new Funcionario();

		f1.setNome("Funcionario");
		f1.setCpf("00000000002");
		f1.setSenha("123");
		f1.setFuncao("Funcionario");

		FuncionariosDAO dao = new FuncionariosDAO();
		dao.salvar(f1);

	}

	@Test
	@Ignore
	public void listar() {

		FuncionariosDAO dao = new FuncionariosDAO();
		List<Funcionario> funcionarios = dao.listar();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario f1 = dao.buscarPorCodigo(1L);
		Funcionario f2 = dao.buscarPorCodigo(4L);

		System.out.println(f1);
		System.out.println(f2);

	}

	@Test
	@Ignore
	public void excluir() {

		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(3L);

		dao.excluir(funcionario);
	}

	@Test
	@Ignore
	public void editar() {

		FuncionariosDAO dao = new FuncionariosDAO();

		Funcionario funcionario = dao.buscarPorCodigo(4L);
		funcionario.setCpf("00000000000");

		dao.editar(funcionario);
	}

}
