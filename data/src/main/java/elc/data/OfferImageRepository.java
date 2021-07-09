package elc.data;

import elc.domain.OfferImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface OfferImageRepository extends JpaRepository<OfferImage, Long> {}