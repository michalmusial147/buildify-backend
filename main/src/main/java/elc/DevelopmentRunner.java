package elc;

import elc.data.*;
import elc.domain.AppUser;
import elc.domain.RenovationBrief;
import elc.domain.cartItem.CartItem;
import elc.domain.offer.Offer;
import elc.domain.OfferImage;
import elc.domain.Role;

import elc.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class DevelopmentRunner  implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OfferImageRepository offerImageRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private RenovationsBriefRepository renovationsBriefRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(AppUser.builder()
                .username("admin@gmail.com")
                .password(passwordEncoder.encode("test1234"))
                .roles(Collections.singletonList(Role.ROLE_ADMIN))
                .firstName("Michał")
                .lastName("Musiał")
                .address1("Warszawa")
                .address2("20")
                .postcode("11-222")
                .telephone("123421234")
                .build());

        AppUser userClient = userRepository.save(AppUser.builder()
                .username("testowy_klient@gmail.com")
                .password(passwordEncoder.encode("test1234"))
                .roles(Arrays.asList(Role.ROLE_USER))
                .firstName("Adam")
                .lastName("Kowalski")
                .address1("Piernikowa")
                .address2("3/24")
                .postcode("11-222")
                .telephone("987645312")
                .build());

        Offer offer;
        OfferImage offerImage;
        List<CartItem> cartItems = null;
        Order order = null;
        for(int c = 0; c< 5 ; c++)
        {
            cartItems = new ArrayList<>();
            order = orderRepository.save(Order
                    .builder()
                    .date(new Date().toString())
                    .appuserId(userClient.getId())
                    .status("accepted")
                    .build());
            for(int i = 0; i< 5 ; i++){
                offer = offerRepository.save(Offer.builder()
                    .title("Produkt".concat(String.valueOf(i)).concat(String.valueOf(c)))
                    .dateAdded(new Date())
                    .description("Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
                    .price((float) Math.floor((Math.random() * (1000 - 10)) + 10))
                    .stock((int) (Math.random() * (500 - 10)) + 10)
                    .category("Kategoria".concat(String.valueOf(c)))
                    .build());

                offerImage = OfferImage.builder()
                    .content(Files.readAllBytes(Paths.get("main/src/main/resources/kafasPlaceholder.jpg")))
                    .offer(offer)
                    .build();

                offerImageRepository.save(offerImage);

                cartItems.add(cartItemsRepository.save(CartItem.builder()
                        .offer(offer)
                        .order(order)
                        .quantity((int) (Math.random() * (100 - 1)) + 1)
                        .build()));
            }
        }
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Remont łazienki 10m2")
                .email("emailtest@email.com")
                .telephone("123123147")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Remont mieszkania 50m2")
                .email("emailtest@email.com")
                .telephone("333323147")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Montaż kabiny prysznicowej")
                .email("ewat@email.com")
                .telephone("999888111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adamdama@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Wymiana okna tarasowego.")
                .email("adam@email.com")
                .telephone("444555111")
                .build());
        renovationsBriefRepository.save(RenovationBrief.builder()
                .date(new Date())
                .description("Monataż bramy garażowej.")
                .email("adam@email.com")
                .telephone("111555111")
                .build());
    }
}
