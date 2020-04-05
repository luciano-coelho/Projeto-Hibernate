package br.com.vendas.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Criar Tabela Produtos*/
@Entity
@Table(name="tb_Vendas")

//M�todo para listar
@NamedQueries({
@NamedQuery(name = "Vendas.listar", query = "SELECT vendas FROM Vendas vendas" ),
//M�todo para Buscar
@NamedQuery(name = "Vendas.buscarPorCodigo", query = "SELECT vendas FROM Vendas vendas WHERE vendas.codigo = :codigo" )
})//Fechamento NamedQuery

public class Vendas {
	
	/*Criar ID com AutoIncrement Na primeira Coluna*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="ven_codigo")
	private Long codigo;
	
	/*Gerar Coluna Passando Horario*/
	@Temporal (value = TemporalType.TIMESTAMP)
	@Column(name="ven_horario", nullable=false)
	private Date horario;
	
	/*Gerar Demais Colunas da Tabela*/
	@Column(name="ven_valor_total", nullable=false, scale = 2, precision = 7)
	private BigDecimal valor_total;


	/*Gerar chave Estrangeira*/
	@JoinColumn(name = "tb_funcionarios_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)

	/*Primeira Passo - Criar Objeto Fornecedor*/
	private Funcionario funcionario;

	
	/*Gerar Getters e Setters*/
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Date getHorario() {
		return horario;
	}


	public void setHorario(Date horario) {
		this.horario = horario;
	}


	public BigDecimal getValor_total() {
		return valor_total;
	}


	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public String toString() {
		return "Vendas [codigo=" + codigo + ", horario=" + horario + ", valor_total=" + valor_total + ", funcionario="
				+ funcionario + "]";
	}
	
	


}
