package com.cg.go.greatoutdoor.exception;

public class WishlistNotFoundException extends RuntimeException{
    public WishlistNotFoundException(){

    }

    public WishlistNotFoundException(String msg){
        super(msg);
    }
}
