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

	public Optional<T> findById(long id) {
		return getRepository().findById(id);
	}

	public T findBy(long id) {
		T obj = getRepository().findOne(id);
		if (obj == null)
			try {
				throw new ServicesException(obj.getClass().getName() + " não existe");

			} catch (ServicesException e) {
				e.printStackTrace();
			}

		return obj;
	}

	public List<T> findByAll() {
		return getRepository().findAll();
	}
	
	@Transactional
	public T save(T objetoDto) {
		return getRepository().save(objetoDto);
	}

	@Transactional
	public T update(long id, T objetoDto) {
		return findById(id).map(record -> {

			T obj = getRepository().save(record);
			return obj;
		}).orElse(null);
	}
	
	@Transactional
	public void remove(long id) {
		findById(id).map(record -> {

			return getRepository().save(record);
		}).orElse(null);
	}

	public void deleteById(long id) {
		getRepository().deleteById(id);
	}

}
