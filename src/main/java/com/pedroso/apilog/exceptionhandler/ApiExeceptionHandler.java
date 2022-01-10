package com.pedroso.apilog.exceptionhandler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class ApiExeceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problem.Field> fieldList = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String field = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fieldList.add(new Problem.Field(field, message));
        }

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDatahora(LocalDateTime.now());
        problem.setTitle("Todos os campos precisam ser preenchidos!");
        problem.setFields(fieldList);
        return handleExceptionInternal(ex, problem, headers, status, request);
    }


}
