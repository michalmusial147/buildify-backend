package elc.domain.offer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import elc.domain.cartItem.CartItem;
import elc.domain.OfferImage;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
@AllArgsConstructor
@Builder
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    private Date dateAdded;

    private float price;

    private boolean available;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "offer")
    private List<OfferImage> offerImages;

    private String category;

    @Column(nullable = true)
    private int stock;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer")
    private List<CartItem> cartItems;
}
