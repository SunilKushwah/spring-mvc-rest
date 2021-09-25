package sun.springfamework.services.impl;

import org.springframework.stereotype.Service;
import sun.springfamework.api.v1.mappper.CustomerMapper;
import sun.springfamework.api.v1.model.CustomerDTO;
import sun.springfamework.repositories.CustomerRepository;
import sun.springfamework.services.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll().stream().map(customer -> {
            CustomerDTO customerDTO = customerMapper.customerToCustomerDto(customer);
            customerDTO.setCustomerUrl("api/v1/customers/"+customer.getId());
            return  customerDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).map(customerMapper::customerToCustomerDto).orElseThrow(RuntimeException::new);
    }
}
