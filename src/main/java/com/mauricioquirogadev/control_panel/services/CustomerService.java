package com.mauricioquirogadev.control_panel.services;

import com.mauricioquirogadev.control_panel.entities.Customer;
import com.mauricioquirogadev.control_panel.entities.dtos.CustomerDTO;
import com.mauricioquirogadev.control_panel.mappers.CustomerMapper;
import com.mauricioquirogadev.control_panel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository repository;
    //obtener un cliente por id
   @Override
    public CustomerDTO getCustomer(Integer id) {
        if( repository.existsById(id)){
            Customer customer = repository.findById(id).get();
            return CustomerMapper.customerToDto(customer);
        }
        return null;
    }
    //obtener todos los clientes
    @Override
    public List<CustomerDTO> getAllCustomer() {
        Iterable<Customer> customers = repository.findAll();
        return StreamSupport.stream(customers.spliterator(), false)
                .map(CustomerMapper::customerToDto) // Mapea cada entidad a un DTO
                .collect(Collectors.toList());
    }
    //agregar un nuevo cliente
    @Override
    public List<CustomerDTO> addCustomer(Customer customer){
       repository.save(customer);
       Iterable<Customer> customers = repository.findAll();
       return StreamSupport.stream(customers.spliterator(), false)
               .map(CustomerMapper::customerToDto) // Mapea cada entidad a un DTO
               .collect(Collectors.toList());
    }
    //eliminar un cliente por id
    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el cliente con ese id"));
        repository.delete(customer);
    }
    //actualiza un cliente definido por el id
    @Override
    public CustomerDTO updateCustomer(Integer id, CustomerDTO updatedCustomer) {
        if (repository.existsById(id)) {
            Customer customerToModify = repository.findById(id).get();


                // Logica del Patch
                if (updatedCustomer.getId() != null) {
                    customerToModify.setId(updatedCustomer.getId());
                }

                if (updatedCustomer.getEmail() != null) {
                    customerToModify.setEmail(updatedCustomer.getEmail());
                }

                if (updatedCustomer.getAddress() != null) {
                    customerToModify.setAddress(updatedCustomer.getAddress());
                }

                if (updatedCustomer.getLastname() != null) {
                    customerToModify.setLastname(updatedCustomer.getLastname());
                }

                if (updatedCustomer.getFirstname() != null) {
                    customerToModify.setFirstname(updatedCustomer.getFirstname());
                }

                Customer customerModified = repository.save(customerToModify);

                return CustomerMapper.customerToDto(customerModified);

        } else {
            // Lanzar la excepción si el usuario no existe
            throw new RuntimeException("no se encontro el cliente con ese id");        }
    }
    //buscar customers en base a parametros
    @Override
    public List<CustomerDTO> searchCustomers(String firstname, String lastname, String email, String address) {
        Iterable<Customer> customers = repository.findAll();

        // Filter customers and map to DTOs in a single stream pipeline
        return StreamSupport.stream(customers.spliterator(), false)
                .filter(cust -> firstname == null || cust.getFirstname().toLowerCase().contains(firstname.toLowerCase()))
                .filter(cust -> lastname == null || cust.getLastname().toLowerCase().contains(lastname.toLowerCase()))
                .filter(cust -> email == null || cust.getEmail().toLowerCase().contains(email.toLowerCase()))
                .filter(cust -> address == null || cust.getAddress().toLowerCase().contains(address.toLowerCase()))
                .map(CustomerMapper::customerToDto)
                .collect(Collectors.toList());
    }

}
