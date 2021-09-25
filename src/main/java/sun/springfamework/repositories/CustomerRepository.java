package sun.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sun.springfamework.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
