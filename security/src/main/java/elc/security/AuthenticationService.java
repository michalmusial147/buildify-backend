package elc.security;


import javax.servlet.http.HttpServletRequest;

import elc.data.UserRepository;
import elc.domain.LoginForm;
import elc.domain.AppUser;
import elc.domain.RegistrationForm;
import elc.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Slf4j
@Service
public class AuthenticationService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private JwtTokenProvider jwtTokenProvider;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    public AppUser signin(LoginForm loginForm) {
        String token = null;
        AppUser usr = userRepository.findByUsername(loginForm.getUsername());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginForm.getUsername(),
                    loginForm.getPassword()));
            token = jwtTokenProvider
                    .createToken(loginForm.getUsername(),
                            userRepository.findByUsername(loginForm.getUsername()).getRoles());
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }
        usr.setToken(token);
        return usr;
    }


    public AppUser signup(RegistrationForm registrationForm) throws UserAlreadyExistException {
        if (userRepository.findByUsername(registrationForm.getUsername()) !=  null) {
            throw new UserAlreadyExistException("User exists", new Exception());
        }
       else {
            AppUser usr = registrationForm.toUser(passwordEncoder);
            usr = userRepository.save(usr);
            usr.setRoles(Arrays.asList(Role.ROLE_USER));
            usr.setToken(jwtTokenProvider.createToken(usr.getUsername(), usr.getRoles()));
            return usr;
        }
    }

    public String editPassword(String password, HttpServletRequest req) {
        AppUser appUser = userRepository
            .findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
        appUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(appUser);
        return jwtTokenProvider.createToken(appUser.getUsername(), appUser.getRoles());
    }
}
