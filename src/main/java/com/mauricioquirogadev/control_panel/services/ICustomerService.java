package com.mauricioquirogadev.control_panel.services;

import com.mauricioquirogadev.control_panel.entities.Customer;
import com.mauricioquirogadev.control_panel.entities.dtos.CustomerDTO;


import java.util.List;

public interface ICustomerService {
    //se sobre entinede que todos estos metodos son públicos
    //obtener un cliente por id
     CustomerDTO getCustomer(Integer id);
    //obtener todos los clientes
     List<CustomerDTO> getAllCustomer();
    //agregar un nuevo cliente
     List<CustomerDTO> addCustomer(Customer customer);
    //eliminar un cliente por id
     void deleteCustomer( Integer id);
    //actualiza un cliente definido por el id

     CustomerDTO updateCustomer(Integer id,  CustomerDTO updatedCustomer) ;
    //buscar customers en base a parametros
     List<CustomerDTO> searchCustomers(
             String firstname,
             String lastname,
             String email,
             String address);


}
