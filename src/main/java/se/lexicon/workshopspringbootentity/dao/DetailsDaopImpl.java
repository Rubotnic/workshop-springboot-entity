package se.lexicon.workshopspringbootentity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopspringbootentity.entity.Details;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DetailsDaopImpl implements DetailsDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Details findById(int detailsId) {
        return entityManager.find(Details.class, detailsId);
    }

    @Transactional
    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("SELECT details FROM Details details", Details.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int detailsId) {
        entityManager.remove(findById(detailsId));
    }
}
