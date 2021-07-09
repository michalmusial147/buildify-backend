package elc.domain;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

import java.util.List;


@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String address1;
  private String address2;
  private String postcode;
  private String telephone;
  private List<Role> roles;

  public AppUser toUser(PasswordEncoder passwordEncoder) {
    return new AppUser(
            username,
            passwordEncoder.encode(password),
            firstName,
            lastName,
            address1,
            address2,
            postcode,
            telephone,
            roles);
  }

}
