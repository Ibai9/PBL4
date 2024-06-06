package com.registro.usuarios.enlace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnlaceController {

    @Autowired
    private EnlaceService enlaceService;

    @PostMapping("/enlaces")
    public void guardarEnlace(@RequestBody Enlace enlace) {
        enlaceService.guardar(enlace);
    }
}
