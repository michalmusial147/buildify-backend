package elc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import elc.domain.offer.Offer;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
@AllArgsConstructor
@Builder
@Table(name = "offerimages")
public class OfferImage {

    @Id
    @GeneratedValue
    Long id;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    byte[] content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = true)
    private Offer offer;

}
