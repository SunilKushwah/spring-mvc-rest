package sun.springfamework.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.springfamework.api.v1.model.CustomerDTO;
import sun.springfamework.api.v1.model.CustomerListDTO;
import sun.springfamework.services.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers(){
        return ResponseEntity.ok().body(new CustomerListDTO(customerService.getAllCustomer()));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable long id){
        return new ResponseEntity(customerService.getCustomerById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO newCustomer = customerService.createNewCustomer(customerDTO);
        return new ResponseEntity(newCustomer, HttpStatus.CREATED);
    }
}
