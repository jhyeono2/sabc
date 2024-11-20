package sabc.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sabc.domain.*;

@RepositoryRestResource(collectionResourceRel = "statuses", path = "statuses")
public interface StatusRepository
    extends PagingAndSortingRepository<Status, Long> {
    List<Status> findByAcceptNo(String acceptNo);
}
