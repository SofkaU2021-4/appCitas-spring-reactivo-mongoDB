package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.domain.Padecimiento;
import com.springBajo8.springBajo8.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins="*")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping("/padecimientos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Padecimiento> save(@RequestBody Padecimiento padecimiento) {
        return service.save(padecimiento);
    }

    @DeleteMapping("/padecimientos/{id}")
    private Mono<ResponseEntity<Padecimiento>> delete(@PathVariable("id") String id) {
        return service.delete(id)
                .flatMap(padecimiento -> Mono.just(ResponseEntity.ok(padecimiento)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/padecimientos/{id}")
    private Mono<ResponseEntity<Padecimiento>> update(@PathVariable("id") String id, @RequestBody Padecimiento padecimiento) {
        return service.update(id, padecimiento)
                .flatMap(padecimiento1 -> Mono.just(ResponseEntity.ok(padecimiento1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/padecimientos/{idPaciente}")
    private Flux<Padecimiento> findByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return service.findByIdPaciente(idPaciente);
    }

    @GetMapping("/padecimientos")
    private Flux<Padecimiento> findAll() {
        return service.findAll();
    }

}