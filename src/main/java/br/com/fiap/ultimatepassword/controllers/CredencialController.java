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

import br.com.fiap.ultimatepassword.models.Credencial;

@RestController
@RequestMapping("ultimatepassword/credencial")
public class CredencialController {
	Logger log = LoggerFactory.getLogger(CredencialController.class);
	ArrayList<Credencial> credenciais = new ArrayList<>();

	@GetMapping
	public ArrayList<Credencial> index() {
		log.info("Consultando credenciais");
		return credenciais;
	}

	@PostMapping
	public ResponseEntity<Credencial> create(@RequestBody Credencial credencial) {
		log.info("Cadastrando credencial " + credencial);
		credenciais.add(credencial);
		return ResponseEntity.status(HttpStatus.CREATED).body(credencial);
	}

	@GetMapping("{id}")
		public ResponseEntity<Credencial> show(@PathVariable Long id) {
			log.info("Detalhando credencial " + id);
			Credencial credencialEncontrado = null;

			for(Credencial credencial: credenciais) {
				if(credencial.getCredencial_id() == id) {
					credencialEncontrado = credencial;
				}
			}

			if(credencialEncontrado == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(credencialEncontrado);
		}

		@DeleteMapping("{id}")
    public ResponseEntity<Credencial> destroy(@PathVariable Long id){
        log.info("apagando credencial " + id);

        for(int i = 0; i < credenciais.size(); i++) {
					if(credenciais.get(i).getCredencial_id() == id) {
						credenciais.remove(i);
						return ResponseEntity.noContent().build();
					}
				}
				
				return ResponseEntity.notFound().build();
    }

		@PutMapping("{id}")
		public ResponseEntity<Credencial> update(@PathVariable Long id, @RequestBody Credencial credencial) {
			log.info("atualizando credencial " + id);
			boolean credencialEncontrado = false;

			for(int i = 0; i < credenciais.size(); i++) {
				if(credenciais.get(i).getCredencial_id() == id) {
					credenciais.remove(i);
					credenciais.add(credencial);
					credencialEncontrado = true;
				}
			}

			if(credencialEncontrado == false) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(credencial);
		}
	
}
