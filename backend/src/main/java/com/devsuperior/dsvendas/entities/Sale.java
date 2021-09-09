package com.devsuperior.dsvendas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity                            //mapeamento dos objetos relacionais do java para os bancos de dados
                                   // cntrol + shift +o para importar o javax.persistence.Entity (fazer com as demais anotacoes

@Table(name = "tb_sales")          //mapeamento identico ao nome da tabela de sales(tb_sales) do bd.
public class Sale {
	@Id                            //identifica para o bd qual atributo eh chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // informa que o arroba id vai ser autoIncrementável
	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;         //cntrl + shift + o para importar java.time.LocalDate
	
	@ManyToOne                      //informa o muitos para 1 do uml
	@JoinColumn(name = "seller_id") //informa qual a chave estrangeira 
	private Seller seller;          // atribuindo ao campo seller a entidade Seller.java

	
	public Sale() {}


	public Sale(Long id, Integer visited, Integer deals, Double amount, LocalDate date, Seller seller) {
	    this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getVisited() {
		return visited;
	}


	public void setVisited(Integer visited) {
		this.visited = visited;
	}


	public Integer getDeals() {
		return deals;
	}


	public void setDeals(Integer deals) {
		this.deals = deals;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
}
