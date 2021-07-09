package elc.web;

import elc.data.OfferRepository;
import elc.data.RenovationsBriefRepository;
import elc.domain.RenovationBrief;
import elc.domain.offer.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/renovation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RenovationBoundary {
    @Autowired
    RenovationsBriefRepository renovationsBriefRepository;

    @GetMapping
    public Iterable<RenovationBrief> getAll() {

        return renovationsBriefRepository.findAll();
    }

}
