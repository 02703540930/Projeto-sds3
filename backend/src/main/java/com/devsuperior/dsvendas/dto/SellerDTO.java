package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SellerDTO implements Serializable{   //recurso pra transformar os dados em bites.
   private static final long serialVersionUID = 1L;
	
   private Long id;
   private String name;
   
   public SellerDTO() {
   }

   public SellerDTO(Long id, String name) {
	   this.id = id;       //this eh pq usa com o atributo
	   this.name = name;
   }
   
   public SellerDTO(Seller entity) {         // aqui vai receber os dados da entidade e passar para o dto
	   id = entity.getId();                 ///sem o this prq eh o parametro dito em Long Id, String Name
	   name = entity.getName();
   }


   public Long getId() {
	   return id;
   }

   public void setId(Long id) {
	   this.id = id;
   }

   public String getName() {
	   return name;
   }

   public void setName(String name) {
   	   this.name = name;
   }
   
   
   
}