package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.exception.ValidarColunaException;

public abstract class GenericService<T> {

	public abstract Optional<T> findById(long id);

	public abstract T findBy(long id) throws ServicesException;

	public abstract List<T> findByAll();

	public abstract T save(T obj) throws EntityExistsException, ValidarColunaException;

	public abstract T update(long id, T obj);

	public abstract void remove(long id);

	public abstract void deleteById(long id);

}
