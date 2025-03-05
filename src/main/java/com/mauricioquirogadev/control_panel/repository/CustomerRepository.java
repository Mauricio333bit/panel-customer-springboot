package com.mauricioquirogadev.control_panel.repository;

import com.mauricioquirogadev.control_panel.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//se debe pasar el modelo y la clave identificadora al repository,esto se implementa en el service
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    // Buscar por firstname (opcional)
    List<Customer> findByFirstname(String firstname);

    // Buscar por lastname (opcional)
    List<Customer> findByLastname(String lastname);

    // Buscar por email (opcional)
    List<Customer> findByEmail(String email);

    // Buscar por address (opcional)
    List<Customer> findByAddress(String address);
}
