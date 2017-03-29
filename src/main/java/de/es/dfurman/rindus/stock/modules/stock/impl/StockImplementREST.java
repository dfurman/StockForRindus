package de.es.dfurman.rindus.stock.modules.stock.impl;

import de.es.dfurman.rindus.stock.modules.stock.api.Stock;
import de.es.dfurman.rindus.stock.modules.stock.model.Product;
import de.es.dfurman.rindus.stock.modules.stock.model.ProductType;
import de.es.dfurman.rindus.stock.modules.stock.service.StockServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
@RestController
@RequestMapping("/api/stock")
public class StockImplementREST implements Stock {

    @Autowired
    private StockServiceImpl stockService;

    @Override
    @ApiOperation(value = "refillStock", nickname = "refillStock")
    @RequestMapping(method = {RequestMethod.POST}, path = "/refillStock", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "Stock ID ", required = true, dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "numberOfProduct", value = "Number of Product to create", required = true, dataType = "integer", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "productType", value = "Product Type", required = true, dataType = "string", paramType = "query", defaultValue = "MID")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Response refillStock(Long stockId, int numberOfProduct, ProductType productType) {
        stockService.addProductToStockByStockIdAndByQuantityOfProductAndProductType(stockId, numberOfProduct, productType);

        return Response.status(201).build();
    }

    @Override
    @ApiOperation(value = "getProductFromStock", nickname = "getProductFromStock")
    @RequestMapping(method = {RequestMethod.POST}, path = "/getProductFromStock", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "Stock ID ", required = true, dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "quantity", value = "Number of Product to get", required = true, dataType = "integer", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "productType", value = "Product Type", required = true, dataType = "string", paramType = "query", defaultValue = "MID")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = de.es.dfurman.rindus.stock.modules.stock.model.Stock.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})

    public ResponseEntity getProductFromStock(Long stockId, int quantity, ProductType productType) {
        List<Product> products = stockService.removeProductFromStockByIdAndByQuantityOfProductAndProductType(stockId, quantity, productType);
        if (products.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);

    }

}
