package elc.data;

import elc.domain.AppUser;
import elc.domain.RenovationBrief;
import org.springframework.data.repository.CrudRepository;

public interface RenovationsBriefRepository  extends CrudRepository<RenovationBrief, Integer> {
}
