package sabc.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "accepts", path = "accepts")
public interface AcceptRepository
    extends PagingAndSortingRepository<Accept, Long> {}
