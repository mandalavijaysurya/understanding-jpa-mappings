package org.getarrayz.understandingjpa.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@ControllerAdvice
public class UnderstandingJPAExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(UserNotFoundException userNotFoundException){
        return new ResponseEntity<String>(userNotFoundException.getMessage(),HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(InterestNotFoundException.class)
    public ResponseEntity<String> interestNotFound(InterestNotFoundException interestNotFoundException){
        return ResponseEntity.of(Optional.of(interestNotFoundException.getMessage()));
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<String> addressNotFound(AddressNotFoundException addressNotFoundException){
        return ResponseEntity.of(Optional.of(addressNotFoundException.getMessage()));
    }

}
