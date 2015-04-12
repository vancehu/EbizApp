package my.ebizapp.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactRepository extends CrudRepository<Transact, Long> {
    List<Transact> findById(long id);
}
