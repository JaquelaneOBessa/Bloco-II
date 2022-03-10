package org.blogpessoal.repository;

import java.util.List;

import org.blogpessoal.model.TemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	public List<TemaModel>findAllByNomeContainingIgnoreCase(String nome);
	
}
