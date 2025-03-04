package com.mauricioquirogadev.control_panel.services;

import com.mauricioquirogadev.control_panel.entities.Customer;


import java.util.List;

public interface ICustomerService {
    //se sobre entinede que todos estos metodos son públicos
    //obtener un cliente por id
     Customer getCustomer( Integer id);
    //obtener todos los clientes
     List<Customer> getAllCustomer();
    //agregar un nuevo cliente
     List<Customer> addCustomer(Customer customer);
    //eliminar un cliente por id
     void deleteCustomer( Integer id);
    //actualiza un cliente definido por el id

     Customer updateCustomer(Integer id,  Customer updatedCustomer) ;
    //buscar customers en base a parametros
     List<Customer> searchCustomers(
             String firstname,
             String lastname,
             String email,
             String address);


}
