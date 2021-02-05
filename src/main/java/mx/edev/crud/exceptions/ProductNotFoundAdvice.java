package mx.edev.crud.exceptions;

import mx.edev.crud.domain.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    CustomErrorResponse productNotFoundHandler(ProductNotFoundException ex) {
        return new CustomErrorResponse(HttpStatus.NOT_FOUND.toString(),ex.getMessage());
    }
}