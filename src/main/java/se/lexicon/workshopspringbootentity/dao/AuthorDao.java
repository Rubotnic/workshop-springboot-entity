package se.lexicon.workshopspringbootentity.dao;

import se.lexicon.workshopspringbootentity.entity.AppUser;
import se.lexicon.workshopspringbootentity.entity.Author;

import java.util.Collection;

public interface AuthorDao {

    Author findById(int authorId);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int authorId);
}
