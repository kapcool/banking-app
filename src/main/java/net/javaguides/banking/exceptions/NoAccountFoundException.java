package net.javaguides.banking.exceptions;

import lombok.Data;

@Data
public class NoAccountFoundException extends RuntimeException{

    public NoAccountFoundException(String msg){
        super(msg);
    }
}
