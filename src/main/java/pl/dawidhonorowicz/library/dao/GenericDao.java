package pl.dawidhonorowicz.library.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class GenericDao<T extends Serializable, K> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> type;
	
	
	@SuppressWarnings("unchecked")
	GenericDao(){
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
	             .getGenericSuperclass();
	        this.type = (Class<T>) genericSuperclass
	             .getActualTypeArguments()[0];
	}
	
	@Transactional
	public void save(T entity) {
		entityManager.persist(entity);
	}
	@Transactional
	public T get(K key) {
		return entityManager.find(type, key);
	}
	
	
	
}
