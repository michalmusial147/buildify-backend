package elc.data;

import elc.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface UserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsername(String userName);

}
