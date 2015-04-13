package my.ebizapp.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findById(long id);

    List<Message> findByIdAndCustomer(long id, Customer customer);

    List<Message> findByIdAndSupplier(long id, Supplier supplier);

    List<Message> findByCustomerOrderByTimeDesc(Customer customer);

    List<Message> findBySupplierOrderByTimeDesc(Supplier supplier);
}
