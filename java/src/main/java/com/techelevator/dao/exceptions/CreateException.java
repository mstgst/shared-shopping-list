package com.techelevator.dao.exceptions;

import org.springframework.dao.DataAccessException;

public class CreateException extends RuntimeException{
    public CreateException(Throwable cause) {
        super(cause);
    }
    public CreateException(String msg){super(msg);}
}
