package sun.springfamework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sun.springfamework.api.v1.mappper.CustomerMapper;
import sun.springfamework.api.v1.model.CustomerDTO;
import sun.springfamework.domain.Customer;
import sun.springfamework.repositories.CustomerRepository;
import sun.springfamework.services.impl.CustomerServiceImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    private Long ID = 1L;
    private String FIRSTNAME = "Sunil";
    private String LASTNAME = "Kushwah";

    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    void getAllCustomer() {

        when(customerRepository.findAll()).thenReturn(Arrays.asList(new Customer(),new Customer()));

        assertEquals(2,customerService.getAllCustomer().size());

    }

    @Test
    void getCustomerById() {
        Customer c1 = new Customer();
        c1.setId(ID);
        c1.setFirstname(FIRSTNAME);
        c1.setLastname(LASTNAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(c1));

        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        assertEquals(ID, customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTNAME, customerDTO.getLastname());

    }

    @Test
    void createNewCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Sunil");
        customerDTO.setLastname("Kushwah");

        Customer savedCustomer = new Customer();
        savedCustomer.setId(1L);
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        CustomerDTO savedDto = customerService.createNewCustomer(customerDTO);

        assertEquals(customerDTO.getFirstname(),savedDto.getFirstname());
        assertEquals(customerDTO.getLastname(),savedDto.getLastname());
        assertEquals("api/v1/customers/1",savedDto.getCustomerUrl());


    }
}