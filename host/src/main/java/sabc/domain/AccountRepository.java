package sabc.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sabc.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "hosts", path = "hosts")
public interface AccountRepository
    extends PagingAndSortingRepository<Account, Long> {}
