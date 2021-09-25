package sun.springfamework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.springfamework.domain.Category;
import sun.springfamework.domain.Customer;
import sun.springfamework.repositories.CategoryRepository;
import sun.springfamework.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomer();
    }

    private void loadCustomer() {
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Sunil");
        customer1.setLastname("Kushwah");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Dev");
        customer2.setLastname("Chaudary");

        Customer customer3 = new Customer();
        customer3.setId(3l);
        customer3.setFirstname("Jitu");
        customer3.setLastname("Singh");

        Customer customer4 = new Customer();
        customer4.setId(4l);
        customer4.setFirstname("Mukesh");
        customer4.setLastname("Gami");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        System.out.println("Customer count:"+customerRepository.count());
     }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        Category dried = new Category();
        dried.setName("Dried");
        Category exotic = new Category();
        exotic.setName("Exotic");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category nuts = new Category();
        dried.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Date Count : "+categoryRepository.count());
    }
}
