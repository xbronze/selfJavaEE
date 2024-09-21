package com.dingli.chapter8.exp;

/**
 * @author: xbronze
 * @date: 2024-09-20 19:58
 * @description: TODO
 */
public class CustomException extends RuntimeException {

    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
