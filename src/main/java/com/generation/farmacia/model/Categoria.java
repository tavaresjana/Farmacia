package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //pra transformar em uma tabela no bd
@Table(name = "tb_categoria") //definindo nome da tabela
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerando e transformando em chave 
	public Long id;
	
	@NotNull
	public String setor;
	
	//relacionamento do tipo para muitos @OneToMany (UMA categoria para VÁRIOS produtos)
	//cascade para que tds atualizações de um tema afetem tds as postagens atreladas a ele
	@OneToMany(mappedBy="categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
