package com.springBajo8.springBajo8.web;


import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins="*")
public class citasReactivaResource {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        return icitasReactivaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/")
    private Mono<ResponseEntity<citasDTOReactiva>> update(@RequestBody citasDTOReactiva citasDTOReactiva) {
        return icitasReactivaService.update(citasDTOReactiva.getId(), citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<citasDTOReactiva> findAll() {
        return icitasReactivaService.findAll();
    }

    @PutMapping("/citasReactivas/cancelar/{id}")
    private Mono<citasDTOReactiva> cancelarCita(@PathVariable("id") String id){
        return icitasReactivaService.cancelarCitaReactiva(id);
    }

    @GetMapping("/citasReactivas/buscarFechaYHora")
    private Flux<citasDTOReactiva> findAllByidPaciente(@RequestBody citasDTOReactiva citasDTOReactiva) {
        return icitasReactivaService.buscarCitaPorFechaYHora(citasDTOReactiva.getFechaReservaCita(),citasDTOReactiva.getHoraReservaCita());
    }

    @GetMapping("/citasReactivas/buscarMedico/{id}")
        private String findNombreMedicoPorId(@PathVariable("id") String id){
        return icitasReactivaService.buscarMedicoCitaReactiva(id);
    }



}
