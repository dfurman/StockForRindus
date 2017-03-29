package de.es.dfurman.rindus.stock.modules.stock;

import de.es.dfurman.rindus.stock.modules.stock.impl.StockImplementREST;
import de.es.dfurman.rindus.stock.modules.stock.model.StockDAO;
import de.es.dfurman.rindus.stock.modules.stock.service.StockServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */

@EnableSwagger2
@ComponentScan(basePackageClasses = {
        StockDAO.class,
        StockImplementREST.class,
        StockServiceImpl.class

})

@SpringBootApplication
@ImportResource({"classpath:dataSource-context.xml", "classpath:persistence-context.xml"})
public class ApplicationStart extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStart.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStart.class, args);
    }


}
