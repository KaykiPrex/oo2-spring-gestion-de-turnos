package com.unla.grupo18.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(NoHandlerFoundException e, Model model) {
        model.addAttribute("status", HttpStatus.NOT_FOUND);
        model.addAttribute("message", "¡Oops! No encontramos lo que buscas.");
        return "error/error-page";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception e, Model model) {
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("message", "Ha ocurrido un error inesperado. Inténtalo más tarde.");
        return "error/default";
    }

}
