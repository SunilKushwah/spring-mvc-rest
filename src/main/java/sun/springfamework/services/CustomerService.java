package sun.springfamework.services;

import sun.springfamework.api.v1.model.CustomerDTO;
import sun.springfamework.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomer();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
}
