package my.ebizapp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findById(long id);
    List<Customer> findByUsernameAndPassword(String username, String password);
}
