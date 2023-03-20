package br.com.fiap.ultimatepassword.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ultimatepassword.models.Conta;

@RestController
@RequestMapping("ultimatepassword/conta")
public class ContaController {
		Logger log = LoggerFactory.getLogger(ContaController.class);
		ArrayList<Conta> contas = new ArrayList<>();

    @GetMapping
    public ArrayList<Conta> index(){
			log.info("Consultando contas");
			return contas;
    }

		@PostMapping
		public ResponseEntity<Conta> create(@RequestBody Conta conta) {
			log.info("Cadastrando conta " + conta);
			contas.add(conta);
			return ResponseEntity.status(HttpStatus.CREATED).body(conta);
		}

		@GetMapping("{id}")
		public ResponseEntity<Conta> show(@PathVariable Long id) {
			log.info("Detalhando conta " + id);
			Conta contaEncontrada = null;

			for(Conta conta: contas) {
				if(conta.getConta_id() == id) {
					contaEncontrada = conta;
				}
			}

			if(contaEncontrada == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(contaEncontrada);
		}

		@DeleteMapping("{id}")
    public ResponseEntity<Conta> destroy(@PathVariable Long id){
        log.info("apagando conta " + id);

        for(int i = 0; i < contas.size(); i++) {
					if(contas.get(i).getConta_id() == id) {
						contas.remove(i);
						return ResponseEntity.noContent().build();
					}
				}
				
				return ResponseEntity.notFound().build();
    }

		@PutMapping("{id}")
		public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta) {
			log.info("atualizando conta " + id);
			boolean contaEncontrada = false;

			for(int i = 0; i < contas.size(); i++) {
				if(contas.get(i).getConta_id() == id) {
					contas.remove(i);
					contas.add(conta);
					contaEncontrada = true;
				}
			}

			if(contaEncontrada == false) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(conta);
		}
}
