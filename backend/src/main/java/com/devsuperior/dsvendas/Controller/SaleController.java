package com.devsuperior.dsvendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")   //endereco para voltar a lista de sales
public class SaleController {
    @Autowired                         
	private SaleService service;
	   
    //metodo para chamar o caminho /sales no navegador lembrando que Pageable para mostrar em paginas
    @GetMapping                                              
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {         
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    
    // /metodo para chamar o caminho /sum-by-seller no navegador do mesmo tipo amoutGrupedBySeller do servico
    @GetMapping(value = "/amount-by-seller")                                             
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {         
        List<SaleSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }
    
    // /metodo para chamar o caminho /success-by-seller no navegador do mesmo tipo successGrupedBySeller do servico
    @GetMapping(value = "/success-by-seller")                                             
    public ResponseEntity<List<SaleSuccessDTO>> SuccessGroupedBySeller() {         
        List<SaleSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
    
}
