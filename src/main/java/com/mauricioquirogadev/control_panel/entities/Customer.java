package com.mauricioquirogadev.control_panel.entities;

import lombok.*;

import java.util.Objects;
//lombok nos simplifica la escitura de codigo con anotaciones, si no funciona debo ir a file-plugin e instalar lombok
//@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString
//las anotaciones de arriba son sustituidas por una sola-> @Data
@Data
public class Customer {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;

}
