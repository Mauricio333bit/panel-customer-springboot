package com.mauricioquirogadev.control_panel.services;

import com.mauricioquirogadev.control_panel.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private List<Customer> list =new ArrayList<>();
    public CustomerService(){
        Customer cust = new Customer();
        cust.setId(1);
        cust.setFirstname("Mauricio");
        cust.setLastname("Quiroga");
        cust.setEmail("mau@gmail.com");
        cust.setAddress("Mendoza");
        Customer cust2 = new Customer();
        cust2.setId(2);
        cust2.setFirstname("Ramon");
        cust2.setLastname("Quiroga");
        cust2.setEmail("ram@gmail.com");
        cust2.setAddress("Bolivia");
        Customer cust3 = new Customer();
        cust3.setId(3);
        cust3.setFirstname("Susana");
        cust3.setLastname("Quiroga");
        cust3.setEmail("sus@gmail.com");
        cust3.setAddress("San Juan");
        list.add(cust);
        list.add(cust2);
        list.add(cust3);
    }
    //obtener un cliente por id
   @Override
    public Customer getCustomer( Integer id) {
        return list.stream()
                .filter(cust -> cust.getId().equals(id))
                .findFirst()
                .orElse(null); // Devuelve null si no se encuentra el cliente
    }
    //obtener todos los clientes
    @Override
    public List<Customer> getAllCustomer(){

        return list;
    }
    //agregar un nuevo cliente
    @Override
    //es importante la anotacion requesbody
    public List<Customer> addCustomer(Customer customer){
        list.add(customer);
        return list;
    }
    //eliminar un cliente por id
    @Override
    public void deleteCustomer( Integer id){
        list.removeIf(cost->cost.getId().equals(id));

    }
    //actualiza un cliente definido por el id
    @Override

    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        for (Customer customer : list) {
            if (customer.getId().equals(id)) {
                customer.setFirstname(updatedCustomer.getFirstname());
                customer.setLastname(updatedCustomer.getLastname());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setAddress(updatedCustomer.getAddress());
                return customer; // Retorna el cliente actualizado
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
    }
    //buscar customers en base a parametros
    @Override
    public List<Customer> searchCustomers(
             String firstname,
             String lastname,
             String email,
             String address) {

        return list.stream()
                .filter(cust -> firstname == null || cust.getFirstname().toLowerCase().contains(firstname.toLowerCase()))
                .filter(cust -> lastname == null || cust.getLastname().toLowerCase().contains(lastname.toLowerCase()))
                .filter(cust -> email == null || cust.getEmail().toLowerCase().contains(email.toLowerCase()))
                .filter(cust -> address == null || cust.getAddress().toLowerCase().contains(address.toLowerCase()))
                .collect(Collectors.toList());
    }

}
