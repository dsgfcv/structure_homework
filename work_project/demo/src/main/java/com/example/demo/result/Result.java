package com.example.demo.result;

import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;
    
    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static Result<String> success(String data){
        return new Result<String>("200", "OK", data);
    }
}
