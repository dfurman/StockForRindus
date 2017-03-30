package de.es.dfurman.rindus.stock.modules.stock.service;

/**
 * Created by furmans on 30.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
public class NotEnoughProductInStock extends Exception {
    public NotEnoughProductInStock(String message) {
        super(message);
    }
}
