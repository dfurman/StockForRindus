package de.es.dfurman.rindus.stock.modules.stock;

import de.es.dfurman.rindus.stock.modules.stock.impl.StockImplementREST;
import de.es.dfurman.rindus.stock.modules.stock.model.StockDAO;
import de.es.dfurman.rindus.stock.modules.stock.service.StockServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
@Configuration
@ComponentScan(basePackageClasses = {
        StockDAO.class,
        StockImplementREST.class,
        StockServiceImpl.class,

})

@ImportResource({"classpath:dataSource-context.xml", "classpath:persistence-context.xml"})
public class TestSpringApplicationContext {
}