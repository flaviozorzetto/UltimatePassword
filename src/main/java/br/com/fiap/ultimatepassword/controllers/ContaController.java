package br.com.fiap.ultimatepassword.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ultimatepassword.models.Conta;

@RestController
public class ContaController {
    @GetMapping("/api/conta")
    public Conta show(){
        Conta conta = new Conta(1, "Teste", "Teste123");
        return conta;
    }
}
