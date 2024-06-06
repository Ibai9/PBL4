package com.registro.usuarios.enlace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnlaceServiceImpl implements EnlaceService {

    @Autowired
    private EnlaceRepository enlaceRepository;

    @Override
    public void guardar(Enlace enlace) {
        enlaceRepository.save(enlace);
    }
}


