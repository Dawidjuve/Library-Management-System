package pl.dawidhonorowicz.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.dawidhonorowicz.library.model.Book;

@Repository
public class BookDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void save(Book book) {
		entityManager.persist(book);
	}
	
	@Transactional
	public Book find(Long id) {
		return entityManager.find(Book.class, id);
	}
}
