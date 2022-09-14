package se.lexicon.workshopspringbootentity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopspringbootentity.entity.AppUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class AppUserDaoImpl implements AppUserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public AppUser findById(int appUserId) {
        return entityManager.find(AppUser.class, appUserId);
    }

    @Transactional
    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT appUser FROM AppUser appuser", AppUser.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int appUserId) {
        entityManager.remove(findById(appUserId));
    }
}
