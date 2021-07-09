package elc.web;

import elc.data.OfferImageRepository;
import elc.data.OfferRepository;
import elc.domain.offer.Offer;
import elc.domain.OfferImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offerImages")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OfferImageBoundary {

    @Autowired
    OfferImageRepository offerImageRepository;
    @Autowired
    OfferRepository offerRepository;


    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable Long imageId) {
        byte[] image = offerImageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getContent();
        return new ByteArrayResource(image);
    }

    @PostMapping
    long uploadImage(@RequestParam ("imageFile") MultipartFile imageFile,
                     @RequestParam(value = "offerId", required = true) Integer offerId) throws IOException {
        OfferImage dbImage = new OfferImage();
        dbImage.setContent(imageFile.getBytes());
        Optional<Offer> offer = offerRepository.findById(offerId);
        dbImage.setOffer(offer.get());
        return offerImageRepository.save(dbImage).getId();
    }

}
