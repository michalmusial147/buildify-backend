package elc.web;

import elc.domain.AppUser;
import elc.domain.LoginForm;
import elc.domain.RegistrationForm;
import elc.security.AuthenticationService;
import elc.security.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/authentication")
@Slf4j
public class AuthenticationBoundary {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationBoundary.class);

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationBoundary(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AppUser> login(@RequestBody LoginForm loginForm) {
        log.info("reached");
        AppUser resp =  authenticationService.signin(loginForm);
        if(resp==null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        else{
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AppUser> signup(@RequestBody RegistrationForm registerForm) {
        try {
            return new ResponseEntity<>(
                    authenticationService.signup(registerForm),
                    HttpStatus.OK );
        }
        catch (UserAlreadyExistException e){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
