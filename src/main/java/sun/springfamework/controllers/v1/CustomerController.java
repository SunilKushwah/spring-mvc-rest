package sun.springfamework.controllers.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }
}
