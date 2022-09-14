package se.lexicon.workshopspringbootentity.dao;

import se.lexicon.workshopspringbootentity.entity.AppUser;
import se.lexicon.workshopspringbootentity.entity.Details;

import java.util.Collection;

public interface DetailsDao {

    Details findById(int detailsId);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int detailsId);
}
