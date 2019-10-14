package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.argus.argus.models.Disciplina;

@Repository
public interface DisciplinaRepositories extends JpaRepository<Disciplina, Long>{

}