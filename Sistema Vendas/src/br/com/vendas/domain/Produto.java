package br.com.vendas.domain;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*Criar Tabela Produtos*/
@Entity
@Table(name="tb_produtos")

public class Produto {
	
	/*Criar ID com AutoIncrement Na primeira Coluna*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="pro_codigo")
	private Long codigo;
	
	/*Gerar Demais Colunas da Tabela*/
	@Column(name="pro_descricao", length=50, nullable=false)
	private String descricao;
	
	@Column(name="pro_preco", nullable=false, scale = 2, precision = 7)
	private BigDecimal preco;
	
	@Column(name="pro_quantidade", nullable=false)
	private Integer quantidade;
	
	/*Gerar chave Estrangeira*/
	@JoinColumn(name = "tb_fornecedores_for_codigo", referencedColumnName = "for_codigo", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)

	/*Primeira Passo - Criar Objeto Fornecedor*/
	private Fornecedor fornecedor;
	
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
}
