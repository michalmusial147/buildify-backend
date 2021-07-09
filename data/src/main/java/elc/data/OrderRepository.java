package elc.data;

import elc.domain.offer.Offer;
import elc.domain.order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
