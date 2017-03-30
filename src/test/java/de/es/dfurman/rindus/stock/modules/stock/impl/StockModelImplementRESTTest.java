package de.es.dfurman.rindus.stock.modules.stock.impl;


import de.es.dfurman.rindus.stock.modules.stock.TestSpringApplicationContext;
import de.es.dfurman.rindus.stock.modules.stock.model.Product;
import de.es.dfurman.rindus.stock.modules.stock.model.ProductType;
import de.es.dfurman.rindus.stock.modules.stock.service.NotEnoughProductInStock;
import de.es.dfurman.rindus.stock.modules.stock.service.StockService;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestSpringApplicationContext.class})
public class StockModelImplementRESTTest {

    @Autowired
    @Qualifier("stockServiceImpl")
    private StockService stockService;

    private static final Logger LOG = Logger.getLogger(StockModelImplementRESTTest.class);

    @BeforeClass
    public static void runOnceBeforeClass() {
    }

    @AfterClass
    public static void runOnceAfterClass() {
    }

    @Test
    public void refillStock() {
        stockService.addProductToStockByStockIdAndByQuantityOfProductAndProductType(1L, 1, ProductType.MID);
    }

    @Test
    public void getProductFromStock() {
        this.refillStock();
        try {
            List<Product> products = stockService.removeProductFromStockByIdAndByQuantityOfProductAndProductType(1L, 1, ProductType.MID);
            Assert.assertNotNull(products);
        } catch (NotEnoughProductInStock notEnoughProductInStock) {
            LOG.error(notEnoughProductInStock.toString());
        }

    }

}