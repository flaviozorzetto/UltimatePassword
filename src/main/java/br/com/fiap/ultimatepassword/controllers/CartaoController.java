package br.com.fiap.ultimatepassword.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.ultimatepassword.models.Cartao;

@RestController
public class CartaoController {
    @GetMapping("/api/cartao")
    public Cartao show(){
        Cartao cartao = new Cartao(1, "Cartão da minha mãe", "ANA DOS SANTOS SILVA", "MasterCard", 02, 2028, 1234);
        return cartao;
    }
    
}
