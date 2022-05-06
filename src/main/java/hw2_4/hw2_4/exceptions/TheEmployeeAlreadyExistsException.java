package hw2_4.hw2_4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TheEmployeeAlreadyExistsException extends RuntimeException {
}
