package br.com.magoos.casadocodigo.model.dto;

import br.com.magoos.casadocodigo.model.AutorModel;

public class AutorDTO {

	private Long id;
	private String nome;
	private String email;
	private String descricao;

	public AutorDTO(AutorModel autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

}
