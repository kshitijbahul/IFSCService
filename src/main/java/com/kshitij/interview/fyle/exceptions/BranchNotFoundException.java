package com.kshitij.interview.fyle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(){
        super();
    }
    public BranchNotFoundException(String  message){
        super(message);
    }
    public BranchNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}
