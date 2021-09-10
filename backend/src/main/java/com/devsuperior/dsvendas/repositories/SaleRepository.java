package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	//busca no banco de dados a soma das vendas de um vendedor. Precisa criar um apelido para cada obj que será buscado, igual aos atributos da entidade(dsvendas.entities)
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " //Seleciona agrupadamente as vendas(os amouts) conforme SaleSumDTO// aqui pode ser utilizado sql raiz, foi utilizado jpql
			+ " FROM Sale AS obj GROUP BY obj.seller")                                         //no FROM precisa ser o mesmo nome da entidade da mesma classe Sale  la no entities Sale.
                                                                                              // e AS obj para buscar os atributos SaleSumDTO(obj.seller, SUM(obj.amount) acima                                              
	List<SaleSumDTO> amountGroupedBySeller();

	//busca no banco de dados a soma das visitas (visited) e dos deals(negocios fechados) de um vendedor. Precisa criar um apelido para cada obj que será buscado, igual aos atributos da entidade(dsvendas.entities)
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " //Seleciona agrupadamente as visitas(os visited) e os negocios fechados (deals) conforme SaleSuccessDTO// aqui pode ser utilizado sql raiz, foi utilizado jpql
			+ " FROM Sale AS obj GROUP BY obj.seller")                                         //no FROM precisa ser o mesmo nome da entidade da mesma classe Sale  la no entities Sale.
                                                                                              // e AS obj para buscar os atributos SaleSuccessDTO(obj.seller, SUM(obj.visited) acima                                              
	List<SaleSuccessDTO> successGroupedBySeller();

}