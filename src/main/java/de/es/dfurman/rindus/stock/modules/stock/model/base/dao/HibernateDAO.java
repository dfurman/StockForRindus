package de.es.dfurman.rindus.stock.modules.stock.model.base.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * HibernateDAO - One of DataAccesObject Implementation
 * Also we can implement FileDAO or another different DAO ex. NoSQL DAO
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
public abstract class HibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    /**
     * Injection of persistence context
     *
     * @return
     */
    protected abstract EntityManager getEntityManager();

    private Class<T> entityGenericClass;

    public HibernateDAO(Class<T> entityGenericClass) {
        this.entityGenericClass = entityGenericClass;
    }

    @Override
    public T findById(ID id) {
        return getEntityManager().find(entityGenericClass, id);
    }

    @Override
    public void create(T object) {
        getEntityManager().persist(object);
    }

    @Override
    public T update(T object) {
        return getEntityManager().merge(object);
    }

    @Override
    public void delete(T object) {
        getEntityManager().remove(object);
    }

    @Override
    public int count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityGenericClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);

        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityGenericClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
