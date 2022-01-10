package com.pedroso.apilog.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problem {

    private Integer status;
    private LocalDateTime datahora;
    private String title;
    private List<Field> fields;

    @AllArgsConstructor
    @Getter
    public static class Field {
        private String field;
        private String message;
    }

}
