        package elc.domain.order;

        import com.fasterxml.jackson.annotation.JsonManagedReference;
        import elc.domain.cartItem.CartItem;
        import elc.domain.cartItem.CartItemDTO;
        import lombok.*;
        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.Iterator;
        import java.util.List;

        @Entity
        @Data
        @NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
        @AllArgsConstructor
        @Builder
        @Table(name = "orders")
        public class Order {

            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private int id;

            @JsonManagedReference
            @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
            private List<CartItem> cartItems;

            private int appuserId;

            private String status;

            private String date = new Date().toString();

            public OrderDTO toDTO(){
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(this.id);
                List<CartItemDTO> cartItemsDTOs = new ArrayList<>();
                Iterator<CartItem> itr = this.cartItems.iterator();
                while (itr.hasNext()) {
                    cartItemsDTOs.add(itr.next().toDTO());
                }
                orderDTO.setCartItems(cartItemsDTOs);
                orderDTO.setUserID(appuserId);
                orderDTO.setDate(date);
                orderDTO.setStatus(status);
                return orderDTO;
            }

        }
