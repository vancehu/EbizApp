package my.ebizapp.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findById(long id);

    List<Customer> findByUsernameAndPassword(String username, String password);
}
