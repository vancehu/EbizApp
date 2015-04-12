package my.ebizapp.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CancelRequestRepository extends CrudRepository<CancelRequest, Long> {
    List<CancelRequest> findById(long id);
}
