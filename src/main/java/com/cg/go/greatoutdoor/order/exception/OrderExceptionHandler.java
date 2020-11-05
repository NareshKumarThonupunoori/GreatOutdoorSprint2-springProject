package com.cg.go.greatoutdoor.order.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.go.greatoutdoor.product.exception.ProductException;
import com.cg.go.greatoutdoor.product.exception.ProductExceptionHandler;

@RestControllerAdvice
public class OrderExceptionHandler {

    private static final Logger Log= LoggerFactory.getLogger(ProductExceptionHandler.class);
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductException.class)
    public String handleProductException(ProductException e){
         return e.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String handleAll(Exception e){
        Log.error("exception caught",e);
        return e.getMessage();
    }
}
