package elc.domain.offer;

import lombok.Data;


@Data
public class OfferDTO {
    String title;
    String description;
    Float price;
    int stock;
    String category;
}
