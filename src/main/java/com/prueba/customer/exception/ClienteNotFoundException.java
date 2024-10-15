package com.prueba.customer.exception;

import com.prueba.customer.repository.entity.CustomError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends RuntimeException  {
    public ClienteNotFoundException(String message) {
        super(message);
    }
}