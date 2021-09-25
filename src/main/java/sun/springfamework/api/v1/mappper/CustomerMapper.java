package sun.springfamework.api.v1.mappper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sun.springfamework.api.v1.model.CustomerDTO;
import sun.springfamework.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDto(Customer customer);
}
