package de.es.dfurman.rindus.stock.modules.stock.service;

import de.es.dfurman.rindus.stock.modules.stock.model.Product;
import de.es.dfurman.rindus.stock.modules.stock.model.ProductType;
import de.es.dfurman.rindus.stock.modules.stock.model.Stock;
import de.es.dfurman.rindus.stock.modules.stock.model.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */

@Transactional
@Component("stockServiceImpl")
public class StockServiceImpl implements StockService {

    @Autowired
    @Qualifier("stockDAO")
    private StockDAO stockDAO;

    @Override
    public void addProductToStockByStockIdAndByQuantityOfProductAndProductType(Long stockId, int quantity, ProductType productType) {
        //get stock by id
        Stock stock = stockDAO.findById(stockId);
        // if new Stock
        List<Product> newProducts = StockHelper.createNewProductListByQuantityAndProductType(quantity, productType);
        if (stock == null) {
            stock = new Stock();
            stock.setProductList(newProducts);
            stockDAO.create(stock);
        } else {
            // create and add new list of product
            stock.getProductList().addAll(newProducts);
            // update and persist
            stockDAO.update(stock);
        }
    }

    @Override
    public List<Product> removeProductFromStockByIdAndByQuantityOfProductAndProductType(Long stockId, int quantity, ProductType productType) {
        // get stock by id
        Stock stock = stockDAO.findById(stockId);
        if (stock == null) {
            return new ArrayList<>();
        } else {
            // get current ProductList
            List<Product> listOfProdcut = stock.getProductList();
            List<Product> productListToRemove = StockHelper.createListOfProductToRemove(quantity, productType, listOfProdcut.stream());
            // change state
            stock.getProductList().removeAll(productListToRemove);
            stockDAO.update(stock);

            return productListToRemove;
        }

    }

}
