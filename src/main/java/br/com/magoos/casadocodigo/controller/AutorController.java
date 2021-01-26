package br.com.magoos.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magoos.casadocodigo.model.AutorModel;
import br.com.magoos.casadocodigo.model.dto.AutorDTO;
import br.com.magoos.casadocodigo.model.form.AutorForm;
import br.com.magoos.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository repository;

	@GetMapping
	public ResponseEntity<AutorDTO> listar() {
		/* TESTE */
		AutorModel teste = new AutorModel("teste", "teste@gmail.com", "teste teste teste");
		AutorDTO sla = new AutorDTO(teste);
		return ResponseEntity.status(HttpStatus.OK).body(sla);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorForm form) {
		String email = repository.findByEmail(form.getEmail());
		if(form.getEmail() == email) {
			System.out.println("Deu ruim meu bom!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {	
			AutorModel autor = form.converter();
			repository.save(autor);
			return ResponseEntity.status(HttpStatus.OK).body(new AutorDTO(autor));
		}
	}

}
