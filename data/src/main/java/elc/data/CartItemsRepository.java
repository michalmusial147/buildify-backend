package elc.data;

import elc.domain.cartItem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {}
