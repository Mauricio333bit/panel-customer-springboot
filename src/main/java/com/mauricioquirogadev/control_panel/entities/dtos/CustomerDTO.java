package com.mauricioquirogadev.control_panel.entities.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {


    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;



}
