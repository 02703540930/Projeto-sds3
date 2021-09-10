package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSuccessDTO implements Serializable {  
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Long visited;     // usa Long para evitar incompatibilidade no bd
	private Long deals;

	public SaleSuccessDTO() {
	}

		public SaleSuccessDTO(Seller seller, Long visited, Long deals) {  //busca o nome do vendedor pela chave estrangeira Seller seller
		this.sellerName = seller.getName();
		this.visited = visited;
		this.deals = deals;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getVisited() {
		return visited;
	}
	public void setVisited(Long visited) {
		this.visited = visited;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}
	
}
