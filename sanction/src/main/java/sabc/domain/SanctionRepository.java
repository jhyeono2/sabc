package sabc.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sabc.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "sanctions", path = "sanctions")
public interface SanctionRepository
    extends PagingAndSortingRepository<Sanction, Long> {}
