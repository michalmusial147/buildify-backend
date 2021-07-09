package elc.domain.cartItem;

import lombok.Data;

@Data
public class CartItemDTO {
    private int id;
    private int quantity;
    private int offerID;
    private int orderID;
}
