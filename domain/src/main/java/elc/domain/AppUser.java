package elc.domain;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import elc.domain.order.Order;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.
                                          SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "appusers")
public class AppUser{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String address1;
  private String address2;
  private String postcode;
  private String telephone;
  private String token;

  @ElementCollection(fetch = FetchType.EAGER)
  @Setter
  private List<Role> roles;

  public AppUser(String username,
                 String password,
                 String firstName,
                 String lastName,
                 String address1,
                 String address2,
                 String postcode,
                 String telephone,
                 List<Role> roles) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address1 = address1;
    this.address2 = address2;
    this.postcode = postcode;
    this.telephone = telephone;
    this.roles =  roles;
  }


}
