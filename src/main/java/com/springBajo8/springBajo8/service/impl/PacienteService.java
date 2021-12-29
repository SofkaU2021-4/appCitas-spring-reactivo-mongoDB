package com.springBajo8.springBajo8.service.impl;


import com.springBajo8.springBajo8.domain.Padecimiento;
import com.springBajo8.springBajo8.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PacienteService  {

    @Autowired
    private PacienteRepository repository;


    public Mono<Padecimiento> save(Padecimiento padecimientoDTOReactivo) {
        return repository.save(padecimientoDTOReactivo);
    }


    public Mono<Padecimiento> delete(String id) {
        return repository
                .findById(id)
                .flatMap(p -> repository.deleteById(p.getId()).thenReturn(p));
    }

    public Mono<Padecimiento> update(String id, Padecimiento padecimientoDTOReactivo) {
        return repository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    padecimientoDTOReactivo.setId(id);
                    return save(padecimientoDTOReactivo);
                })
                .switchIfEmpty(Mono.empty());
    }


    public Flux<Padecimiento> findByIdPaciente(String idPaciente) {
        return repository.findByIdPaciente(idPaciente);
    }


    public Flux<Padecimiento> findAll() {
        return repository.findAll();
    }
}
