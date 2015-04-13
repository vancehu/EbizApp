package my.ebizapp.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Vance on 4/11/2015.
 */
public class ExceptionHandlingController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(DataIntegrityViolationException e) {
        if (e.getCause().getCause().getMessage().contains("duplicate"))
            throw new BadRequestException("duplicate");
        else
            throw new InternalServerErrorException("unexpected");

    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    final class InternalServerErrorException extends RuntimeException {
        public InternalServerErrorException(String msg) {
            super(msg);
        }
    }
}

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
final class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }
}