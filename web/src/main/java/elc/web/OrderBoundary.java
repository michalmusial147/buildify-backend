package elc.web;

import elc.data.CartItemsRepository;
import elc.data.OfferRepository;
import elc.data.OrderRepository;
import elc.domain.cartItem.CartItem;
import elc.domain.cartItem.CartItemDTO;
import elc.domain.offer.Offer;
import elc.domain.order.Order;
import elc.domain.order.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderBoundary {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartItemsRepository cartItemsRepository;
    @Autowired
    OfferRepository offerRepository;

    @GetMapping
    Iterable<OrderDTO> get( ) {
        Iterable<Order> ordersFromDatabase = orderRepository.findAll();
        Iterator<Order> itr = ordersFromDatabase.iterator();
        List<OrderDTO> ordersToSend = new ArrayList<>();
        while (itr.hasNext()) {
            ordersToSend.add(itr.next().toDTO());
        }
        return ordersToSend;
    }

    @PostMapping
    OrderDTO post(@RequestBody List <CartItemDTO> cartItemsDTOs, @RequestParam(value = "userId", required = true) Integer userId){
        Order order = new Order();
        order.setAppuserId(userId);
        orderRepository.save(order);
        List <CartItem> cartItems = new ArrayList<>();
        for (CartItemDTO cartItemDTO: cartItemsDTOs) {
                CartItem cartItem = new CartItem();
                cartItem.setId(cartItemDTO.getId());
                cartItem.setQuantity(cartItemDTO.getQuantity());
                cartItem.setOffer(offerRepository.findById(cartItemDTO.getOfferID()).get());
                cartItem.setOrder(order);
                cartItemsRepository.save(cartItem);
                cartItems.add(cartItem);
            }
        order.setCartItems(cartItems);
        return order.toDTO();
    }


}

