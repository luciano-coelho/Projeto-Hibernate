package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Criar Tabela Fornecedores*/
@Entity
@Table(name="tb_fornecedores")

public class Fornecedor {
	
	/*Criar ID com AutoIncrement Na primeira Coluna*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="for_codigo")
	private Long codigo;
	
	/*Gerar Demais Colunas da Tabela*/
	@Column(name="for_descricao", length=50, nullable=false)
	private String descricao;
	
	
	/*Gerar Getters e Setters*/
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
