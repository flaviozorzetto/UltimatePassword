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
import br.com.fiap.ultimatepassword.models.Cartao;

@RestController
@RequestMapping("ultimatepassword/cartao")
public class CartaoController {
		ArrayList<Cartao> cartoes = new ArrayList<>();
		Logger log = LoggerFactory.getLogger(CartaoController.class);

    @GetMapping
    public ArrayList<Cartao> index(){
			log.info("Consultando cartões");
      return cartoes;
    }

		@PostMapping
		public ResponseEntity<Cartao> create(@RequestBody Cartao cartao) {
			log.info("Cadastrando cartao " + cartao);
			cartoes.add(cartao);
			return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
		}

		@GetMapping("{id}")
		public ResponseEntity<Cartao> show(@PathVariable Long id) {
			log.info("detalhando cartão " + id);
			Cartao cartaoEncontrado = null;

			for(Cartao cartao: cartoes) {
				if(cartao.getCartao_id() == id) {
					cartaoEncontrado = cartao;
				}
			}

			if(cartaoEncontrado == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(cartaoEncontrado);
		}

		@DeleteMapping("{id}")
    public ResponseEntity<Cartao> destroy(@PathVariable Long id){
        log.info("apagando cartão " + id);

        for(int i = 0; i < cartoes.size(); i++) {
					if(cartoes.get(i).getCartao_id() == id) {
						cartoes.remove(i);
						return ResponseEntity.noContent().build();
					}
				}
				
				return ResponseEntity.notFound().build();
    }

		@PutMapping("{id}")
		public ResponseEntity<Cartao> update(@PathVariable Long id, @RequestBody Cartao cartao) {
			log.info("atualizando cartão " + id);
			boolean cartaoEncontrado = false;

			for(int i = 0; i < cartoes.size(); i++) {
				if(cartoes.get(i).getCartao_id() == id) {
					cartoes.remove(i);
					cartoes.add(cartao);
					cartaoEncontrado = true;
				}
			}

			if(cartaoEncontrado == false) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(cartao);
		}
    
}
