package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.ServicesException;

@Service
public abstract class ServiceGeneric<T> {

	// Pega um obj do tipo repository das classe filhas e repassa para os métodos
	public abstract JpaRepository<T, Long> getRepository();

	public Optional<T> findById(Long id) {
		Optional<T> t = getRepository().findById(id);
		if (!t.isPresent())
			throw new ServicesException(t.getClass() + " não encontrado");
		return t;
	}

	public List<T> findByAll() {
		return getRepository().findAll();
	}

	@Transactional
	public T save(T objetoDto) {
		return getRepository().save(objetoDto);
	}

	@Transactional
	public T update(T objetoDto) {
		return getRepository().save(objetoDto);
	}

	@Transactional
	public T update(Long id, T objeto) {
		return findById(id).map(record -> {
			T obj = getRepository().save(record);
			return obj;
		}).orElse(null);
	}

	@Transactional
	public void remove(Long id) {
		findById(id).map(record -> {
			return getRepository().save(record);
		}).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		getRepository().deleteById(id);
	}
	
	@Transactional
	public List<T> delete(T objeto) {
		getRepository().delete(objeto);
		
		return getRepository().findAll();
		
	}

}
