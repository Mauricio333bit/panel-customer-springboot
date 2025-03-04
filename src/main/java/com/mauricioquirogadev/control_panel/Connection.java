package com.mauricioquirogadev.control_panel;

import lombok.Getter;
import lombok.Setter;

//patron singleton para que todo el proyecto comparta una unica instancia de la conxeion
@Getter @Setter
public class Connection {

    private static Connection instance;
     private String username;
     private String password;
     private String host;
     private String port;

    private Connection (){};
    public static Connection getInstance(){
        if(instance==null) {
            instance= new Connection();
        }
        return instance;
    }
}
