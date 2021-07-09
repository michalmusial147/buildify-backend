package elc.domain.order;

import elc.domain.cartItem.CartItemDTO;
import lombok.Data;

@Data
public class OrderDTO {
    private int id;
    private int userID;
    private String date;
    private String status;
    private Iterable<CartItemDTO> cartItems;
}
