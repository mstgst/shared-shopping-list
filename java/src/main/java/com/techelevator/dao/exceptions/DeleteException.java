package com.techelevator.dao.exceptions;

import org.springframework.dao.DataAccessException;

public class DeleteException extends RuntimeException{
    public DeleteException(Throwable cause) {
        super(cause);
    }
    public DeleteException(String msg) {
        super(msg);
    }
}
