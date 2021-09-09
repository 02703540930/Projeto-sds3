package com.devsuperior.dsvendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")   //endereco para voltar a lista de selles
public class SellerController {
    @Autowired                         
	private SellerService service;
	
   
     //metodo para chamar o caminho /sellers no navegador   
    @GetMapping                                              
    public ResponseEntity<List<SellerDTO>> findAll() {             
        List<SellerDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
    
}
