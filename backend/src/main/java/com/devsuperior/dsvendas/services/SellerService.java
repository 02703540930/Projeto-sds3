package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {              // cria uma camada de servico que depende de um reposito. as camadas servico e dados
	
	@Autowired
	private SellerRepository repository; //atributo que fara a ligacaoo com a camada de servico e de acesso
	
	public List<SellerDTO> findAll(){       //cntrl alt o para importar o java.util.List
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList()); //converte a lista de seller(dados da entidade) para sellerDTO	
	}

 }
