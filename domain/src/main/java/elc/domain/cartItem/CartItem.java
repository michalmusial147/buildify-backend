package elc.domain.cartItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import elc.domain.offer.Offer;
import elc.domain.order.Order;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
@AllArgsConstructor
@Builder
@Table(name = "cartitems")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = true)
    private Offer offer;

    public CartItemDTO toDTO() {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(id);
        cartItemDTO.setQuantity(quantity);
        cartItemDTO.setOfferID(offer.getId());
        cartItemDTO.setOrderID(order.getId());
        return  cartItemDTO;
    }


}
