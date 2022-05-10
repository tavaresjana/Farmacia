package com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //para mapear ela como uma tabela de banco de dados
@Table(name="tb_produto") //definindo o nome da tabela
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estamos indicando p o BD criar automaticamente nosso ID //com esse atributo ele vai se tornar uma PRIMARY KEY
	public Long id;
	
	@NotNull // define que o campo é obrigatório
	public String tipoProduto;
		
	@NotNull
	@Size(min = 5, max = 100, message="O campo deve ter no  mínimo 5 caracteres e no máximo 100 caracteres") // define um numero min e max de caracteres no campo 
	public String nomeProduto;
	
	@NotNull //valida se o valor não é nulo
	public double preco;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
