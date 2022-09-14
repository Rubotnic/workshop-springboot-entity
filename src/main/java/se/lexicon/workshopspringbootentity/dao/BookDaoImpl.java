package se.lexicon.workshopspringbootentity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopspringbootentity.entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Book findById(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Transactional
    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT book FROM Book book", Book.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int bookId) {
        entityManager.remove(findById(bookId));
    }
}
