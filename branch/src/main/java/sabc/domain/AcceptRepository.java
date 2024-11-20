package sabc.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sabc.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "accepts", path = "accepts")
public interface AcceptRepository
    extends PagingAndSortingRepository<Accept, Long> {}
