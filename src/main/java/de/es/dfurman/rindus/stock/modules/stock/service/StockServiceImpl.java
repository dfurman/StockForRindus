package de.es.dfurman.rindus.stock.modules.stock.service;

import de.es.dfurman.rindus.stock.modules.stock.model.Product;
import de.es.dfurman.rindus.stock.modules.stock.model.ProductType;
import de.es.dfurman.rindus.stock.modules.stock.model.StockDAO;
import de.es.dfurman.rindus.stock.modules.stock.model.StockModel;
import org.apache.log4j.Logger;
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

    private static final Logger LOG = Logger.getLogger(StockServiceImpl.class);

    @Override
    public void addProductToStockByStockIdAndByQuantityOfProductAndProductType(Long stockId, int quantity, ProductType productType) {
        //get stockModel by id
        StockModel stockModel = stockDAO.findById(stockId);
        // if new StockModel
        List<Product> newProducts = StockHelper.createNewProductListByQuantityAndProductType(quantity, productType);
        if (stockModel == null) {
            LOG.info("Create new StockModel with ID " + stockId);
            stockModel = new StockModel();
            stockModel.setId(stockId);
            stockModel.setProductList(newProducts);
            stockDAO.create(stockModel);
        } else {
            LOG.info("Add new Products to Exist StockModel");
            stockModel.getProductList().addAll(newProducts);
            // update and persist
            stockDAO.update(stockModel);
        }
    }

    @Override
    public List<Product> removeProductFromStockByIdAndByQuantityOfProductAndProductType(Long stockId, int quantity, ProductType productType) throws NotEnoughProductInStock {
        // get stockModel by id
        StockModel stockModel = stockDAO.findById(stockId);
        if (stockModel == null) {
            LOG.info("Stock with ID " + stockId + " does not exist");
            return new ArrayList<>();
        } else {
            // get current ProductList
            List<Product> listOfProdcut = stockModel.getProductList();
            if (listOfProdcut.size() < quantity) {
                LOG.error("Not enought product in stock ");
                throw new NotEnoughProductInStock("NOT ENOUGH");
            } else {
                List<Product> productListToRemove = StockHelper.createListOfProductToRemove(quantity, productType, listOfProdcut.stream());
                LOG.info("Remove Procuts form stock " + productListToRemove.toString());
                stockModel.getProductList().removeAll(productListToRemove);
                stockDAO.update(stockModel);

                return productListToRemove;
            }
        }

    }

}
