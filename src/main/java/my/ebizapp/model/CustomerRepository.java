package my.ebizapp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findById(long id);
    List<Customer> findByUsernameAndPassword(String username, String password);
}
