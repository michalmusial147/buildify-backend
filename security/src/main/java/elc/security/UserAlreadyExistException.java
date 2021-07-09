package elc.security;

import org.springframework.security.core.AuthenticationException;

public class UserAlreadyExistException extends AuthenticationException {

    public UserAlreadyExistException(String msg, Throwable t) {
        super(msg, t);
    }
}
