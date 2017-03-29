package de.es.dfurman.rindus.stock.modules.stock.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Duplication object available
     * I used the List interface cause the same Product can be stocked in warehouse
     * One direct relations - from Stock to List of Product
     */
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Stock() {
    }
}
