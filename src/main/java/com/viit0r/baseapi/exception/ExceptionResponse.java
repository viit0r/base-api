package com.viit0r.baseapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    private String message;
}
