

        package elc.data;

        import elc.domain.offer.Offer;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;

        public interface OfferRepository extends CrudRepository<Offer, Integer> {

            Iterable<Offer> findAllByOrderByDateAddedDesc();
            Iterable<Offer> findAllByOrderByDateAddedAsc();
            Iterable<Offer> findAllByOrderByPriceDesc();
            Iterable<Offer> findAllByOrderByPriceAsc();

            @Query(value = "SELECT distinct category FROM offers", nativeQuery = true)
            Iterable<String> findAllCategories();
        }




