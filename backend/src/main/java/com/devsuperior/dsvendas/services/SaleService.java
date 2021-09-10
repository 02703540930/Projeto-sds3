package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {              // cria uma camada de servico que depende de um reposito. as camadas servico e dados
	
	@Autowired
	private SaleRepository repository; //atributo que fara a ligacaoo com a camada de servico e de acesso
	
	
	@Autowired
	private SellerRepository sellerRepository; //organiza as buscas para nao gerar muitos selects no bd. obs. funciona em memoria entao serve para poucos registros
		
	// aqui faz a configuracao de buscar apenas alguns registros paginados para mostrar no navegador (Pageable pageable)
	@Transactional (readOnly = true)                       //readOnly é para nao fazer lock no banco, manter somente em memoria
	public Page<SaleDTO> findAll(Pageable pageable){       //cntrl alt o para importar o java.util.List
		sellerRepository.findAll();                        //aloca em memoria a lista de seller pra nao gerar muitos selects
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));            //lista de sale(dados da entidade/repositorio) para saleDTO	
	}
    
	
	//Criado o Metodo na camada de servico para retornar a lista das vendas agrupadas do DTO
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	//Criado o Metodo na camada de servico para retornar a lista das visitas e negocios fechados agrupadas do DTO
		@Transactional(readOnly = true)
		public List<SaleSuccessDTO> successGroupedBySeller(){
			return repository.successGroupedBySeller();
		}
 }
