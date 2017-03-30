package de.es.dfurman.rindus.stock.modules.stock.model;

import de.es.dfurman.rindus.stock.modules.stock.TestSpringApplicationContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestSpringApplicationContext.class})
public class StockModelDAOTest {

    @Autowired
    @Qualifier("stockDAO")
    private StockDAO stockDAO;

    void setUp() {

    }

    @Test
    public void create() {
        stockDAO.create(new StockModel());
        Assert.assertEquals(1, stockDAO.count());
    }

}