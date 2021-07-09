package elc.web;

import elc.data.OfferImageRepository;
import elc.data.OfferRepository;
import elc.data.UserRepository;
import elc.domain.offer.Offer;
import elc.domain.offer.OfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/offers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OfferBoundary {

    @Autowired
    OfferRepository offerRepository;
    @Autowired
    OfferImageRepository offerImageRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<Offer> getAllOffers() {
        Iterable<Offer> offers = null;
        offers = offerRepository.findAll();
        List<Offer> array = StreamSupport
                .stream(offers.spliterator(), false)
                .collect(Collectors.toList());
        return array;
    }
    @GetMapping(value = "/{id}")
    public Offer getOffer(@PathVariable Integer id) {

        return offerRepository.findById(id).get();
    }
    @PostMapping
    public Offer addOne(@RequestBody OfferDTO offerDTO){
        Offer offer = Offer.builder()
                .title(offerDTO.getTitle())
                .dateAdded(new Date())
                .description(offerDTO.getDescription())
                .price(offerDTO.getPrice())
                .stock(offerDTO.getStock())
                .category(offerDTO.getCategory())
                .build();

        return offerRepository.save(offer);
    }

    @PutMapping
    public Offer editOne(@RequestBody Offer offer){
        return offerRepository.save(offer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteOne(@PathVariable Integer id){
        Offer offer = offerRepository.findById(id).get();
        offerImageRepository.delete( offer.getOfferImages().get(0));


        offerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping(value = "/categories")
    public Iterable<String> getAllCategories() {

        return offerRepository.findAllCategories();
    }
}
