package sabc.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sabc.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "reviews", path = "reviews")
public interface ReviewRepository
    extends PagingAndSortingRepository<Review, Long> {}
