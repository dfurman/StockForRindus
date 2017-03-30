package de.es.dfurman.rindus.stock.modules.stock.model;

import de.es.dfurman.rindus.stock.modules.stock.model.base.CommonEntity;

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
@Table(name = "product")
public class Product extends CommonEntity {

    @Transient
    public static final String MOCK_NAME="Prodcut_";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    public Product() {
    }

    public Product(String productName, ProductType productType) {
        this.productName = productName;
        this.productType = productType;
    }

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productType=" + productType +
                '}';
    }
}
