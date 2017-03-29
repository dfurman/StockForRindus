package de.es.dfurman.rindus.stock.modules.stock.model;

import de.es.dfurman.rindus.stock.modules.stock.model.base.dao.HibernateDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
@Transactional
@Component("stockDAO")
public class StockDAO extends HibernateDAO<Stock, Long> {

    /**
     * Inject Persistence Context
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Create object property - concrete-abstract inheritance
     *
     * @See HibernateDAO
     */
    public StockDAO() {
        super(Stock.class);
    }
}
