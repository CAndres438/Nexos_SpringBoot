package com.auto_inventory_1.exceptions;

public class ProductInvalidException extends RuntimeException{
    public ProductInvalidException(String message){
        super(message);
    }
}
