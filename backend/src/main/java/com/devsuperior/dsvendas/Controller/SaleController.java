package com.devsuperior.dsvendas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")   //endereco para voltar a lista de sales
public class SaleController {
    @Autowired                         
	private SaleService service;
	   
    //metodo para chamar o caminho /sales no navegador, lembrando que Pageable para mostrar   
    @GetMapping                                              
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {         
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    
}