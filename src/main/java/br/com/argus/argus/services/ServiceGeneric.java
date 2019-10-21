package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.argus.argus.exception.ServicesException;

public abstract class ServiceGeneric<T> {

//	JpaRepository<T, Long> repository;

	// Pega um obj do tipo repository das classe filhas e repassa para os métodos
	public abstract JpaRepository<T, Long> getRepository();

	public Optional<T> findById(long id) {
		return getRepository().findById(id);
	}

	public T findBy(long id) throws ServicesException {
		T obj = getRepository().findOne(id);
		if (obj == null)
			throw new ServicesException(obj.getClass().getName() + " não existe");

		return obj;

	}

	public List<T> findByAll() {
		return getRepository().findAll();
	}

	public T save(T objetoDto) {
		return getRepository().save(objetoDto);
	}

	public T update(long id, T objetoDto) {
		return findById(id).map(record -> {

			T obj = getRepository().save(record);
			return obj;
		}).orElse(null);
	}

	public void remove(long id) {
		findById(id).map(record -> {

			return getRepository().save(record);
		}).orElse(null);
	}

	public void deleteById(long id) {
		getRepository().deleteById(id);
	}

}
