package br.com.magoos.casadocodigo.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.magoos.casadocodigo.model.AutorModel;

public class AutorForm {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public AutorModel converter() {
		return new AutorModel(this.nome, this.email, this.descricao);
	}

}
