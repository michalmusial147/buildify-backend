package elc.security;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {

    @Override
    public abstract String getMessage();

    public abstract HttpStatus getHttpStatus();
}
