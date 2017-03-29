package de.es.dfurman.rindus.stock.modules.stock.api;

import de.es.dfurman.rindus.stock.modules.stock.model.ProductType;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
public interface Stock {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response refillStock(final Long stockId, final int numberOfProduct, final ProductType productType);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response getProductFromStock(final Long stockId, final int quantity, final ProductType productType);

}
