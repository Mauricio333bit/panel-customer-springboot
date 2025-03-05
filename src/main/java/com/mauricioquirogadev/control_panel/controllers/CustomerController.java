package com.mauricioquirogadev.control_panel.controllers;

import com.mauricioquirogadev.control_panel.entities.Customer;
import com.mauricioquirogadev.control_panel.entities.dtos.CustomerDTO;
import com.mauricioquirogadev.control_panel.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
//la idea del controller es que solo  maneje las peticiones, la logica la maneja el service

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService service = new CustomerService();

    //obtener un cliente por id
    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Integer id) {
        return service.getCustomer(id);
    }
    //obtener todos los clientes
    @GetMapping("/getAll")
    public List<CustomerDTO> getAllCustomer(){

        return service.getAllCustomer();
    }
    //agregar un nuevo cliente
    @PostMapping("/add")
    //es importante la anotacion requesbody
    public List<CustomerDTO> addCustomer( @RequestBody Customer customer){
        return service.addCustomer(customer);
    }
    //eliminar un cliente por id
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
    service.deleteCustomer(id);
    }
    //actualiza un cliente definido por el id
    @PutMapping("/update/{id}")

    public CustomerDTO updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO updatedCustomer) {
        return service.updateCustomer(id,updatedCustomer);
    }
    //buscar customers en base a parametros
    @GetMapping("/search")
    public List<CustomerDTO> searchCustomers(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address) {

        return service.searchCustomers(firstname,lastname,email,address);
    }


}
