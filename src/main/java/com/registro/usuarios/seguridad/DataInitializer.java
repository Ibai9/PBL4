package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public void run(String... args) throws Exception {
        String email = "user@proba";
        if (usuarioServicio.findByEmail(email) == null) {
            UsuarioRegistroDTO userDto = new UsuarioRegistroDTO();
            userDto.setNombre("user");
            userDto.setApellido("proba");
            userDto.setEmail(email);
            userDto.setPassword("12345");
            usuarioServicio.guardar(userDto);
        }
    }
}
