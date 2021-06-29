package io.github.mateusmsc.clientes.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors( List<String> erros){
        this.errors = erros;
    }

    public ApiErrors( String message){
        // Transformando um objeto em lista
        this.errors = Arrays.asList(message);
    }
}
