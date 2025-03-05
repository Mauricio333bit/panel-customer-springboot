package com.mauricioquirogadev.control_panel.mappers;

import com.mauricioquirogadev.control_panel.entities.Customer;
import com.mauricioquirogadev.control_panel.entities.dtos.CustomerDTO;
import lombok.experimental.UtilityClass;
@UtilityClass
public class CustomerMapper {



        // TODO: REFACTOR BUILDER
        public CustomerDTO customerToDto(Customer customer){
            CustomerDTO dto =new CustomerDTO();
            dto.setId(customer.getId());
            dto.setFirstname(customer.getFirstname());
            dto.setLastname(customer.getLastname());
            dto.setEmail(customer.getEmail());
            dto.setAddress(customer.getAddress());
            return dto;
        }

        public Customer dtoToCustomer(CustomerDTO dto){
            Customer customer = new Customer();
            customer.setId(dto.getId());
            customer.setEmail(dto.getEmail());
            customer.setFirstname(dto.getFirstname());
            customer.setLastname(dto.getLastname());
            customer.setAddress(dto.getAddress());
            return customer;
        }

}
