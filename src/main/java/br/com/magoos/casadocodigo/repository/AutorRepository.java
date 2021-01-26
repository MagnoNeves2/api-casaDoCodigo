package br.com.magoos.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magoos.casadocodigo.model.AutorModel;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long> {

	String findByEmail(String email);

}
