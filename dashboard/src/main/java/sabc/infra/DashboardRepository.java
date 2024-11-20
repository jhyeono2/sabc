package sabc.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sabc.domain.*;

@RepositoryRestResource(collectionResourceRel = "dashboard", path = "dashboard")
public interface DashboardRepository
    extends PagingAndSortingRepository<Dashboard, Long> {
    List<Dashboard> findByAcceptNo(String acceptNo);
}
